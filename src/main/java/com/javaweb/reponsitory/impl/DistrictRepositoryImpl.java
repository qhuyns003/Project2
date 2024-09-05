package com.javaweb.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.javaweb.reponsitory.DistrictRepository;
import com.javaweb.reponsitory.entity.BuildingEntity;
import com.javaweb.reponsitory.entity.DistrictEntity;
import com.javaweb.utils.ConnectionJDBCUtil;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {
	
	@Override
	public DistrictEntity findById(Long id) {
		StringBuilder sql = new StringBuilder("select district.id, district.code,district.name from district");
		DistrictEntity  result = new DistrictEntity();
		sql.append(" where district.id="+ id);
		try(Connection conn = ConnectionJDBCUtil.getConnection();
				Statement stm =conn.createStatement();
				ResultSet rs =stm.executeQuery(sql.toString())){
			
				
			while(rs.next()) {
				result.setId(rs.getLong("district.id"));
				result.setCode(rs.getString("district.code"));
				result.setName(rs.getString("district.name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
