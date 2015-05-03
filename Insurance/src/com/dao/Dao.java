package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bean.Customer;
import com.bean.Vehicle;

/**
 * The DAO for All the SQL statements 
 * used in this project
 * @author Benjamin Lin
 * date: Jun 20, 2014
 * 
 */
public class Dao {

	public static Connection con;
	
	/**
	 * Get All Users Customer Bean is used here
	 * @throws SQLException
	 */
	public static List<Customer> getAllCustomers() {
		con = ConnectionManager.getConnection();		
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
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return customerList;
	}

	/**
	 * Get next available customer ID
	 * @return next available customer ID
	 * @throws SQLException 
	 */
	public static int getID() {
		con = ConnectionManager.getConnection();
		int id = 0;
		String sql = "select id from customer";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				id = rs.getInt("id");				
			}
			id += 1;
			System.out.println("new id: " + id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return id;
	}
	
	
	/**
	 * Add a new customer to DB
	 * @param cus Customer to be added to DB
	 * @throws SQLException 
	 */
	public static void addCustomer(Customer cus) {
		con = ConnectionManager.getConnection();
		if (con != null) {
			String sql = "insert into customer values (?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, getID());
				ps.setString(2, cus.getFirstname());
				ps.setString(3, cus.getLastname());
				ps.setString(4, cus.getPolicyNo());
				ps.setString(5, cus.getPhone());
				ps.setString(6, cus.getEmail());
				ps.setString(7, cus.getAAA());		
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * Update a customer information except his ID
	 * @param cus the customer to be updated
	 * @throws SQLException 
	 */
	public static void updateCustomer(Customer cus) {
		con = ConnectionManager.getConnection();
		if (con != null) {
			String sql = "update customer " +
					"set firstname = ?, lastname = ?, policyno = ?, phone = ?, email = ?, aaa = ?" +
					"where id = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, cus.getFirstname());
				ps.setString(2, cus.getLastname());
				ps.setString(3, cus.getPolicyNo());
				ps.setString(4, cus.getPhone());
				ps.setString(5, cus.getEmail());
				ps.setString(6, cus.getAAA());
				ps.setInt(7, cus.getID());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static List<Vehicle> getAllVehicles(int cusid) {
		con = ConnectionManager.getConnection();
		List<Vehicle> vehicleList = new ArrayList<Vehicle>();
		if (con != null) {
			String sql = "select * from vehicle where cusid = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, cusid);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Vehicle v = new Vehicle();
					v.setVin(rs.getString("vin"));
					v.setMake(rs.getString("make"));
					v.setModel(rs.getString("model"));
					v.setType(rs.getString("type"));
					v.setYear(rs.getInt("year"));
					v.setPicture(rs.getString("picture"));
					v.setAmount(rs.getDouble("amount"));
					v.setCusid(rs.getInt("cusid"));
					vehicleList.add(v);
				}
				return vehicleList;
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return vehicleList;
	}
	
	
	public static void updateVehicle(Vehicle v) {
		con = ConnectionManager.getConnection();
		if (con != null) {
			String sql = "update vehicle " +
					"set make = ?, model = ?, type = ?, year = ?, picture = ?, amount = ? " +
					"where vin = ?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, v.getMake());
				ps.setString(2, v.getModel());
				ps.setString(3, v.getType());
				ps.setInt(4, v.getYear());
				ps.setString(5, v.getPicture());
				ps.setDouble(6, v.getAmount());
				ps.setString(7, v.getVin());				
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void insertVehicle(Vehicle v) {
		con = ConnectionManager.getConnection();
		if (con != null) {
			String sql = "insert into vehicle values (?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, v.getVin());
				ps.setString(2, v.getMake());
				ps.setString(3, v.getModel());
				ps.setString(4, v.getType());
				ps.setInt(5, v.getYear());
				ps.setString(6,  v.getPicture());
				ps.setDouble(7, v.getAmount());
				ps.setInt(8, v.getCusid());
				ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
