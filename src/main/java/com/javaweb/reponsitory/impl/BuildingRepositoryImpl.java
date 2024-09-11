package com.javaweb.reponsitory.impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.model.SearchingDTO;
import com.javaweb.reponsitory.BuildingRepository;
import com.javaweb.reponsitory.entity.BuildingEntity;
import com.javaweb.utils.ConnectionJDBCUtil;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
@Primary
public class BuildingRepositoryImpl implements BuildingRepository{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public static void joinTable(BuildingSearchBuilder buildingSearchBuilder,StringBuilder sql) {
		if(buildingSearchBuilder.getStaffid() != null) {
			sql.append(" inner join assignmentbuilding on building.id = assignmentbuilding.buildingid  ");
		};
		if(buildingSearchBuilder.getDistrictid() != null) {
			sql.append(" inner join district on building.districtid = district.id ");
		};
		if(buildingSearchBuilder.getAreaTo() != null || buildingSearchBuilder.getAreaFrom() != null ) {
			sql.append(" inner join rentarea on rentarea.buildingid=building.id  ");
		};
		if(buildingSearchBuilder.getTypecode() != null) {
			sql.append(" inner join buildingrenttype on building.id = buildingrenttype.buildingid ");
			sql.append(" inner join renttype on renttype.id = buildingrenttype.renttypeid ");
		};
		
	};
	public static void querryNormal(BuildingSearchBuilder buildingSearchBuilder,StringBuilder sql) {
		try {
			Field[] field = BuildingSearchBuilder.class.getDeclaredFields();
			for(Field item : field) {
				item.setAccessible(true);
				String fieldName = item.getName();
				if( !fieldName.equals("staffid") &&!fieldName.equals("typecode") &&!fieldName.startsWith("area")
						&&!fieldName.startsWith("price")) {
					Object value = item.get(buildingSearchBuilder);
				
					if(value!=null){
					if(item.getType().getName().equals("java.lang.Long") || item.getType().getName().equals("java.lang.Integer")) {
							sql.append(" and building."+fieldName+" = "+value);
						}
					else if(item.getType().getName().equals("java.lang.String")) {
							sql.append(" and building."+fieldName+" like '%"+value+"%' ");
						};
					};
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		};
	};
	
	public static void querrySpecial(BuildingSearchBuilder buildingSearchBuilder,StringBuilder sql) {
		if(buildingSearchBuilder.getStaffid() != null) {
			sql.append(" and assignmentcustomer.staffid = "+buildingSearchBuilder.getStaffid());
		};
		if(buildingSearchBuilder.getPriceFrom() != null) {
			sql.append(" and building.rentprice >= "+buildingSearchBuilder.getPriceFrom());
		};
		if(buildingSearchBuilder.getPriceTo() != null) {
			sql.append(" and building.rentprice <= "+buildingSearchBuilder.getPriceTo());
		};
		if(buildingSearchBuilder.getAreaFrom() != null) {
			sql.append(" and rentarea.value >= "+buildingSearchBuilder.getAreaFrom());
		};
		if(buildingSearchBuilder.getAreaTo() != null) {
			sql.append(" and rentarea.value <= "+buildingSearchBuilder.getAreaTo());
		};
		if(buildingSearchBuilder.getTypecode() != null) {
			sql.append(" and ( ");
			sql.append(buildingSearchBuilder.getTypecode().stream().map(it -> " renttype.code like '%" + it + "%' ").collect(Collectors.joining(" or ")));
			sql.append(" ) ");
		};
		
	}
	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {
		StringBuilder sql = new StringBuilder("select building.id,building.name,building.districtid, building.ward, building.street, building.numberofbasement, building.managername, building.managerphonenumber, building.floorarea, building.rentprice, building.servicefee from building ");
		
		joinTable(buildingSearchBuilder,sql);
		sql.append(" where 1=1 ");
		querryNormal(buildingSearchBuilder,sql);
		querrySpecial(buildingSearchBuilder,sql);
		sql.append(" group by building.id ");
		
		Query query = entityManager.createNativeQuery(sql.toString(),BuildingEntity.class);
	
		return query.getResultList();
	}

	

}
