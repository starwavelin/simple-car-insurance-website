package com.starwavelin.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.starwavelin.model.Vehicle;

public class VehicleMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
		Vehicle vhc = new Vehicle();
		
		vhc.setVin(rs.getString("vin"));
		vhc.setMake(rs.getString("make"));
		vhc.setModel(rs.getString("model"));
		vhc.setType(rs.getString("type"));
		vhc.setYear(rs.getInt("year"));
		vhc.setPicture(rs.getString("picture"));
		vhc.setAmount(rs.getDouble("amount"));
		
		/* vhc.setYear(rs.getInt("cusid"));
		* The above careless mistake caused  
		* Request processing failed; nested exception is java.lang.NullPointerException!!!
		*/
		
		vhc.setCusid(rs.getInt("cusid"));
		
		/* The statement below definitely cause NullPointerException!!!
		return null;
		*/
		// Maybe I have been continuously coding several hours so I lost attention to details...
		
		return vhc;
	}
}
