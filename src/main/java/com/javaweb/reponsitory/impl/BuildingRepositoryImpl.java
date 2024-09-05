package com.javaweb.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.model.SearchingDTO;
import com.javaweb.reponsitory.BuildingRepository;
import com.javaweb.reponsitory.entity.BuildingEntity;
import com.javaweb.utils.ConnectionJDBCUtil;
import com.javaweb.utils.NumberUtil;
import com.javaweb.utils.StringUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	
	public static void joinTable(HashMap<String,String> building,ArrayList<String> type,StringBuilder sql) {
		if(StringUtil.checkString(building.get("staffid"))) {
			sql.append(" inner join assignmentbuilding on building.id = assignmentbuilding.buildingid  ");
		};
		if(StringUtil.checkString(building.get("districtid"))) {
			sql.append(" inner join district on building.districtid = district.id ");
		};
		if(StringUtil.checkString(building.get("areaFrom")) || StringUtil.checkString(building.get("areaTo"))) {
			sql.append(" inner join rentarea on rentarea.buildingid=building.id  ");
		};
		if(type != null || (type != null && type.size() ==0 )) {
			sql.append(" inner join buildingrenttype on building.id = buildingrenttype.buildingid ");
			sql.append(" inner join renttype on renttype.id = buildingrenttype.renttypeid ");
		};
		
	};
	public static void querryNormal(HashMap<String,String> building,ArrayList<String> type,StringBuilder sql) {
		for(Map.Entry<String, String > it : building.entrySet()) {
			if( !it.getKey().equals("staffid") &&!it.getKey().equals("typecode") &&!it.getKey().startsWith("area")
					&&!it.getKey().startsWith("price")) {
				if(StringUtil.checkString(it.getValue())) {
					if(NumberUtil.checkNumber(it.getKey())) {
						sql.append(" and building."+it.getKey()+" = "+it.getValue());
					}
					else {
						sql.append(" and building."+it.getKey()+" like '%"+it.getValue()+"%' ");
					};
				};
			}
		}
	};
	
	public static void querrySpecial(HashMap<String,String> building,ArrayList<String> type,StringBuilder sql) {
		if(StringUtil.checkString(building.get("staffid"))) {
			sql.append(" and assignment.staffid = "+building.get("staffid"));
		};
		if(StringUtil.checkString(building.get("priceFrom"))) {
			sql.append(" and building.price >= "+building.get("priceFrom"));
		};
		if(StringUtil.checkString(building.get("priceTo"))) {
			sql.append(" and building.price <= "+building.get("priceTo"));
		};
		if(StringUtil.checkString(building.get("areaFrom"))) {
			sql.append(" and rentarea.value >= "+building.get("areaFrom"));
		};
		if(StringUtil.checkString(building.get("areaTo"))) {
			sql.append(" and rentarea.value <= "+building.get("areaTo"));
		};
		if(type != null && type.size()!=0) {
			sql.append(" and ( ");
			sql.append(type.stream().map(it -> " renttype.code like '%" + it + "%' ").collect(Collectors.joining(" or ")));
			sql.append(" ) ");
		};
		
	}
	@Override
	public ArrayList<BuildingEntity> findAll(HashMap<String,String> building,ArrayList<String> type) {
		StringBuilder sql = new StringBuilder("select building.id,building.name,building.districtid, building.ward, building.street, building.numberofbasement, building.managername, building.managerphonenumber, building.floorarea, building.rentprice, building.servicefee,building.brokeragefee from building ");
		
		ArrayList<BuildingEntity> result = new ArrayList<>();
		joinTable(building,type,sql);
		sql.append(" where 1=1 ");
		querryNormal(building,type,sql);
		querrySpecial(building,type,sql);
		sql.append(" group by building.id ");
		
		try(Connection conn =  ConnectionJDBCUtil.getConnection();
				Statement stm =conn.createStatement();
				ResultSet rs =stm.executeQuery(sql.toString())){
			
			while(rs.next()) {
				BuildingEntity entity= new BuildingEntity();
				entity.setId(rs.getLong("building.id"));
				entity.setBrokeragefee(rs.getLong("building.brokeragefee"));
				entity.setDistrictid(rs.getLong("building.districtid"));
				entity.setFloorarea(rs.getLong("floorarea"));
				entity.setName(rs.getString("building.name"));
				entity.setManagername(rs.getString("managername"));
				entity.setManagerphonenumber(rs.getString("managerphonenumber"));
				entity.setNumberofbasement(rs.getLong("numberofbasement"));
				entity.setRentprice(rs.getLong("rentprice"));
				entity.setServicefee(rs.getLong("servicefee"));
				entity.setStreet(rs.getString("street"));
				entity.setWard(rs.getString("ward"));
				result.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	

}
