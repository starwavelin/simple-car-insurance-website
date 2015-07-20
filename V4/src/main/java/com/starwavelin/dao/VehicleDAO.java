package com.starwavelin.dao;

import java.util.List;

import com.starwavelin.model.Vehicle;

public interface VehicleDAO {
	
	void saveOrUpdate(Vehicle vhc);
	
	void delete(String vin);
	
	void deleteVehicleByCusid(int cusid);
	
	Vehicle get(String vin);
	
	List<Vehicle> list();
	
}
