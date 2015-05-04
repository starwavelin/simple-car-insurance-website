package bean;

import java.io.Serializable;

/**
 * The pojo for vehicles
 * @author Benjamin Lin
 *
 */
public class Vehicle implements Serializable {
	
	private String vin, make, model, type, picture;
	private int year, cusid;	// cusid is the one associated with customerID
	private double amount;
	
	public Vehicle() {}
	
	
	// Accessor methods
	public String getVin() {return vin;}
	public String getMake() {return make;}
	public String getModel() {return model;}
	public String getType() {return type;}
	public int getYear() {return year;}
	public String getPicture() {return picture;}	
	public double getAmount() {return amount;}
	public int getCusid() {return cusid;}
	
	// Mutator methods
	public void setVin(String vin) {
		this.vin = vin;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setPicture(String picture) {
		this.picture = picture;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void setCusid(int cusid) {
		this.cusid = cusid;
	}
	
}
