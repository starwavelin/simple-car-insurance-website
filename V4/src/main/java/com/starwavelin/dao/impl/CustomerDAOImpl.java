package com.starwavelin.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.starwavelin.dao.CustomerDAO;
import com.starwavelin.model.Customer;
import com.starwavelin.dao.mapper.CustomerMapper;


public class CustomerDAOImpl implements CustomerDAO {

	private JdbcTemplate jdbcTemplate;

	public CustomerDAOImpl(DataSource datasource) {
		jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public void saveOrUpdate(Customer cus) {
		if (cus.getId() > 0) {
			// update
			String sql = "update customer set firstname = ?, "
					+ "lastname = ?, policyno = ?, phone = ?, email = ?, aaa = ? where id = ?";
			jdbcTemplate.update(sql, cus.getFirstname(), cus.getLastname(), cus.getPolicyno(), cus.getPhone(),
					cus.getEmail(), cus.getAaa(), cus.getId());
		} else {
			// insert
			String sql = "insert into customer (firstname, lastname, policyno, phone, email, aaa) "
					+ "values (?, ?, ?, ?, ?, ?) ";
			jdbcTemplate.update(sql, cus.getFirstname(), cus.getLastname(), cus.getPolicyno(), cus.getPhone(),
					cus.getEmail(), cus.getAaa());
		}
	}

	@Override
	public void delete(int id) {
		//TODO: invoke VehicleDAOImpl's deleteVehicleByCusid(id); 
		String sql = "delete from customer where id = ?";
		jdbcTemplate.update(sql, id);
	}

	@Override
	public Customer get(int id) {
		String sql = "select * from Customer where id = ?";
		Customer cus = jdbcTemplate.queryForObject(sql, new Object[]{id}, new CustomerMapper());
		return cus;
	}

	@Override
	public List<Customer> list() {
		String sql = "select * from Customer";
		List<Customer> cusList = jdbcTemplate.query(sql, new CustomerMapper()); 
		return cusList;
	}
}