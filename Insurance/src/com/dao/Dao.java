package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Customer;

public class Dao {
	
	private Connection con;
	private final static String scheme = "insurance";
	private final static String dbuser = "root";
	private final static String dbpsword = "tomcat";
	
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + scheme, dbuser, dbpsword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Get Connection
	 * @return Connection con
	 */
	public Connection getConnection () {
		return con;
	}
	
	
	/**
	 * Get All Users
	 * Customer Bean is used here
	 * @throws SQLException 
	 */	
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		if (con != null) {			
			String sql = "select * from customer";
			Statement st = null;
			ResultSet rs = null;
			try {				
				while (rs.next()) {
					Customer cus = new Customer();
					cus.setID(rs.getInt("id"));
					
					// append the customerList
					customerList.add(cus);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (rs != null){
					try {
						rs.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}					
				if (st != null) {
					try {
						st.close();
					}catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		
		return customerList;
	}
	
	
	
	
	
	/**
	 * Close Connection
	 */
	public void closeConnection() {
		if (con !=  null) {
			try {
				con.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
