package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Customer;
import com.bean.Vehicle;

/**
 * The DAO for #1 Connection to MySQL database #2 All the SQL statements used in
 * this project
 * 
 * @author Benjamin Lin
 * 
 */
public class Dao {

	private Connection con;
	private final static String scheme = "insurance";
	private final static String dbuser = "root";
	private final static String dbpsword = "tomcat";

	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"
					+ scheme, dbuser, dbpsword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get Connection
	 * 
	 * @return Connection con
	 */
	public Connection getConnection() {
		return con;
	}

	/**
	 * Get All Users Customer Bean is used here
	 * 
	 * @throws SQLException
	 */
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		if (con != null) {
			String sql = "select * from customer";
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				while (rs.next()) {
					Customer customer = new Customer();
					// There are 7 columns in the "customer" table
					customer.setID(rs.getInt("id"));
					customer.setFirstname(rs.getString("firstname"));
					customer.setLastname(rs.getString("lastname"));
					customer.setPolicyNo(rs.getString("policyno"));
					customer.setPhone(rs.getString("phone"));
					customer.setEmail(rs.getString("email"));
					customer.setAAA(rs.getString("aaa"));
					// append the customerList
					customerList.add(customer);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		return customerList;
	}

	/**
	 * Get next available customer ID
	 * @return next available customer ID
	 */
	public int getID() {
		int id = 0;
		String sql = "select id from customer";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			System.out.println(rs.getInt("id"));
			if (rs.next()) {
				id = rs.getInt("id") + 1;
				System.out.println("new id: " + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	
	
	public void addCustomer(Customer cus) {
		if (con != null) {
			String sql = "insert into customer values (?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, this.getID());
				ps.setString(2, cus.getFirstname());
				ps.setString(3, cus.getLastname());
				ps.setString(4, cus.getPolicyNo());
				ps.setString(5, cus.getPhone());
				ps.setString(6, cus.getEmail());
				ps.setString(7, cus.getAAA());				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
	
	
	/**
	 * Close Connection
	 */
	public void closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
