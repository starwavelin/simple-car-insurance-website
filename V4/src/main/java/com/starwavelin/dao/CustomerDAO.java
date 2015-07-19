package com.starwavelin.dao;

import java.util.List;

import com.starwavelin.model.Customer;

public interface CustomerDAO {
	
	void saveOrUpdate(Customer cus);
	
	void delete(int id);
	
	Customer get(int id);
	
	List<Customer> list();
	
}
