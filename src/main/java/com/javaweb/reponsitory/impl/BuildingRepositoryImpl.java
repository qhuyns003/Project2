package com.javaweb.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.javaweb.reponsitory.BuildingRepository;
import com.javaweb.reponsitory.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository{
	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER ="root";
	static final String PASS="123456789";
	
	@Override
	public ArrayList<BuildingEntity> findAll(String name) {
		String sql ="select * from building where name like '%"+name+"%'";
		ArrayList<BuildingEntity> result = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
				Statement stm =conn.createStatement();
				ResultSet rs =stm.executeQuery(sql);){
			while(rs.next()) {
				BuildingEntity building= new BuildingEntity();
				building.setName(rs.getString("name"));
				building.setStreet(rs.getString("street"));
				building.setWard(rs.getString("ward"));
				building.setNumberOfBasement(rs.getInt("numberOfBasement"));
				result.add(building);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
