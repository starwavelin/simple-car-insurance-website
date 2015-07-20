package com.starwavelin.model;

public class Customer {
	private int id;
	private String firstname, lastname, policyno, phone, email, aaa;
	private int count; // count the number of customers
		
	// Accessor Methods
	public int getID() { return id; }
	public String getFirstname() { return firstname;}
	public String getLastname() { return lastname;}
	public String getPolicyno() { return policyno;}
	public String getPhone() { return phone;}
	public String getEmail() { return email;}
	public String getAaa() { return aaa;}
	public int getCount() { return count; }
	
	public void setID(int id) {
		this.id = id;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setPolicyNo(String policyno) {
		this.policyno = policyno;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAAA(String aaa) {
		this.aaa = aaa;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
}
