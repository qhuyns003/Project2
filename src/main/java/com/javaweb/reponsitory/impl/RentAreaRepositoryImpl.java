package com.javaweb.reponsitory.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.javaweb.reponsitory.RentAreaRepository;
import com.javaweb.reponsitory.entity.DistrictEntity;
import com.javaweb.reponsitory.entity.RentAreaEntity;
import com.javaweb.utils.ConnectionJDBCUtil;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository{
	
	public static void joinTable(StringBuilder sql) {
		sql.append(" inner join building on rentarea.buildingid = building.id ");
	};
	
	@Override
	public ArrayList<RentAreaEntity> findById(Long id) {
		
		StringBuilder sql = new StringBuilder("select distinct rentarea.value from rentarea");
		joinTable(sql);
		sql.append("where 1=1 and rentarea.buildingid ="+id);
		ArrayList<RentAreaEntity> result = new ArrayList<>();
		try(Connection conn = ConnectionJDBCUtil.getConnection();
				Statement stm =conn.createStatement();
				ResultSet rs =stm.executeQuery(sql.toString())){
			
				
			while(rs.next()) {
				RentAreaEntity entity = new RentAreaEntity();
				entity.setValue(rs.getLong("rentarea.value"));
				result.add(entity);
			};
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
