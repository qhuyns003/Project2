package com.javaweb.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.javaweb.model.SearchingDTO;
import com.javaweb.reponsitory.BuildingRepository;
import com.javaweb.reponsitory.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER ="root";
	static final String PASS="123456789";
	@Override
	public ArrayList<BuildingEntity> findAll(SearchingDTO building) {
		String sql ="select building.name,building.servicefee,building.ward,building.street,district.name,building.numberofbasement,building.managername,building.managerphonenumber,building.floorarea,building.rentprice,building.servicefee,building.brokeragefee,group_concat(distinct rentarea.value separator ', ') as dientichthue  \r\n" + 
				"from building \r\n" + 
				"inner join  rentarea \r\n" + 
				"on building.id=rentarea.buildingid\r\n" + 
				"inner join district\r\n" + 
				"on building.districtid=district.id\r\n"+
				"inner join assignmentbuilding\r\n"+
				"on assignmentbuilding.buildingid=building.id\r\n"+
				"inner join user\r\n"+
				"on user.id=assignmentbuilding.staffid\r\n"+
				"inner join buildingrenttype\r\n"+
				"on buildingrenttype.buildingid=building.id\r\n"+
				"inner join renttype\r\n"+
				"on renttype.id=buildingrenttype.renttypeid\r\n"+
				"where 1=1 "; 
		if(building.getName()!=null && building.getName()!="")sql+=" and building.name like '%"+building.getName()+"%' ";
		if(building.getFloorArea()!=null)sql+=" and floorarea="+building.getFloorArea()+" ";
		if(building.getIdDistrict()!=null && building.getIdDistrict()!="")sql+=" and district.id="+building.getIdDistrict()+" ";
		if(building.getWard()!= null && building.getWard()!="")sql+=" and ward="+building.getWard()+" ";
		if(building.getStreet()!=null && building.getStreet()!="")sql+=" and street="+building.getStreet()+" ";
		if(building.getNumberOfBasement()!=null)sql+=" and numberofbasement="+building.getNumberOfBasement()+" ";
		if(building.getDirection()!=null && building.getDirection()!="")sql+=" and direction = "+building.getDirection()+" ";
		if(building.getLevel()!= null && building.getLevel() !="")sql+=" and level = "+building.getLevel()+" ";
		if(building.getAreaFrom()!=null)sql+=" and rentarea >="+building.getAreaFrom()+" ";
		if(building.getAreaTo()!=null)sql+=" and rentarea <="+building.getAreaTo()+" ";
		if(building.getPriceFrom()!=null)sql+=" and rentprice>="+building.getPriceFrom()+" ";
		if(building.getPriceTo()!=null)sql+=" and rentprice <="+building.getPriceTo()+" ";
		if(building.getNameOfManager()!=null)sql+=" and nameofmanager="+building.getNameOfManager()+" ";
		if(building.getPhoneOfManager()!=null)sql+=" and phoneofmanager="+building.getPhoneOfManager()+" ";
		sql+="\r\n";
		sql+=" group by building.id\r\n";
		sql+="having 1=1 ";
		if(building.getEmployee() != null && building.getEmployee()!="")sql+=" and group_concat(user.id separator ', ' ) like '%"+building.getEmployee()+"%' ";
		
		if( building.getTypeOfBuilding() != null) {
			for(String x : building.getTypeOfBuilding()) {
				sql+=" and group_concat( renttype.name separator ', ' ) like '%"+x+"%' ";
			}
		}
		ArrayList<BuildingEntity> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stm =conn.createStatement();
				ResultSet rs =stm.executeQuery(sql);){
			while(rs.next()) {
				BuildingEntity entity= new BuildingEntity();
				entity.setDistrict(rs.getString("district.name"));
				entity.setWard(rs.getString("ward"));
				entity.setStreet(rs.getString("street"));
				entity.setBrokerageFee(rs.getLong("brokeragefee"));;
				entity.setFloorArea(rs.getLong("floorarea"));
				entity.setName(rs.getString("building.name"));
				entity.setNameOfManager(rs.getString("managername"));
				entity.setNumberOfBasement(rs.getLong("numberofbasement"));
				entity.setPhoneOfManager(rs.getString("managerphonenumber"));
				entity.setRentArea(rs.getString("dientichthue"));
				entity.setRentPrice(rs.getLong("rentprice"));
				entity.setServiceFee(rs.getLong("servicefee"));
				result.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	

}
