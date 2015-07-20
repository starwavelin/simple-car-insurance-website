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
		vhc.setYear(rs.getInt("cusid"));
		return null;
	}
}
