package com.starwavelin.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.starwavelin.controller.HomeController;
import com.starwavelin.dao.VehicleDAO;
import com.starwavelin.dao.mapper.VehicleMapper;
import com.starwavelin.model.Vehicle;

public class VehicleDAOImpl implements VehicleDAO {

	private JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(VehicleDAOImpl.class);
	
	public VehicleDAOImpl(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public void saveOrUpdate(Vehicle vhc) {
		if (vhc.getVin() != null) {
			logger.info("Inside VehicleDAOImpl - updateVehicle method");
			
			// update
			String sql = "update vehicle set make = ?, model = ?, type = ?, year = ?, picture = ?, amount = ?"
					+ " where vin = ?";
			jdbcTemplate.update(sql, vhc.getMake(), vhc.getModel(), vhc.getType(),
					vhc.getYear(), vhc.getPicture(), vhc.getAmount(), vhc.getVin()) ;
		} else {
			logger.debug("Inside VehicleDAOImpl - addVehicle method");
			
			// insert
			String sql = "insert into vehicle (vin, make, model, type, year, picture, amount, cusid) "
					+ "values (?, ?, ?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(sql, vhc.getVin(), vhc.getMake(), vhc.getModel(), vhc.getType(),
					vhc.getYear(), vhc.getPicture(), vhc.getAmount(), vhc.getCusid());
		}
	}

	@Override
	public void delete(String vin) {
		String sql = "delete from vehicle where vin = ?";
		jdbcTemplate.update(sql, vin);
	}

	@Override
	public void deleteVehicleByCusid(int cusid) {
		String sql = "delete from vehicle where cusid = ?";
		jdbcTemplate.update(sql, cusid);
	}	
	
	@Override
	public Vehicle get(String vin) {
		String sql = "select * from vehicle where vin = ?";
		Vehicle vhc = jdbcTemplate.queryForObject(sql, new Object[]{vin}, new VehicleMapper());
		return vhc;
	}

	@Override
	public List<Vehicle> list(int cusid) throws DataAccessException {
		logger.info("Inside Class VehicleDAOImpl, function list(int cusid)");
		
		/* DEBUG: To avoid null point exception, i don't use ? for this sql. */
//		String sql = "select * from vehicle where cusid = " + cusid;  
		
		String sql = "select * from vehicle where cusid = ?";
		List<Vehicle> vhcList = jdbcTemplate.query(sql, new Object[]{cusid}, new VehicleMapper());
		return vhcList;
	}	
}
