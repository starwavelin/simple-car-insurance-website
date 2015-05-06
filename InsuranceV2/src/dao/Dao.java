package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import bean.Customer;
import bean.Vehicle;


public class Dao {
	
	private static Connection con = null;
	
	public static User login(User u) {
		con = ConnectionManager.getConnection();
		String username = u.getUsername();
		String password = u.getPassword();
		try {
			String sql = "select * from admin where username = ? and password = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			boolean flag = rs.next();
			if (flag == true) {
				System.out.println(username + " loginned successfully.");
				u.setValid(true);
			} else {
				System.out.println(username + " has login error!!");
				u.setValid(false);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static List<Customer> getCustomerList() {
		con = ConnectionManager.getConnection();
		List<Customer> cList = new ArrayList<Customer>();
		try {
			String sql = "select * from customer";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Customer c = new Customer();
				c.setID(rs.getInt("id"));
				c.setFirstname(rs.getString("firstname"));
				c.setLastname(rs.getString("lastname"));
				c.setPolicyNo(rs.getString("policyno"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setAAA(rs.getString("aaa"));
				cList.add(c);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	/*public static int getID() {
		con = ConnectionManager.getConnection();
		int id = 0;
		try {
			String sql = "select id from customer";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				id = rs.getInt("id");
			}
			id += 1; // Get next available ID for Customer
			ps.close();
			con.close(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}*/
	
	public static boolean insertCustomer(Customer c) {
		con = ConnectionManager.getConnection();
		boolean flag = false;
		try {
			String sql = "insert into customer (firstname, lastname, policyno, phone, email, aaa) "
					+ "values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			//ps.setInt(1, getID());
			ps.setString(1, c.getFirstname());
			ps.setString(2, c.getLastname());
			ps.setString(3, c.getPolicyNo());
			ps.setString(4, c.getPhone());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getAAA());
			int val = ps.executeUpdate();
			if (val > 0) {
				flag = true;
			} else  {
				flag = false;
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean editCustomer(Customer c) {
		con = ConnectionManager.getConnection();
		boolean flag = false;
		try {
			String sql = "update customer set firstname = ?, lastname = ?, policyno = ?, phone = ?, email = ?, aaa = ? where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, c.getFirstname());
			ps.setString(2, c.getLastname());
			ps.setString(3, c.getPolicyNo());
			ps.setString(4, c.getPhone());
			ps.setString(5 ,c.getEmail());
			ps.setString(6, c.getAAA());
			ps.setInt(7, c.getID());
			int val = ps.executeUpdate();
			if (val > 0) {
				flag = true;
			} else  {
				flag = false;
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteCustomer(int id) {
		// Delete the vehicles that have this id as their cusid
		deleteVehicleByCusid(id);
		// Delete the customer record with this id
		con = ConnectionManager.getConnection();
		boolean flag = false;
		try {
			String sql = "delete from customer where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int val = ps.executeUpdate();
			if (val > 0) {
				flag = true;
			} else  {
				flag = false;
			}
			ps.close();
			con.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static List<Vehicle> getVehicleByCusid(int cusid) {
		con = ConnectionManager.getConnection();
		List<Vehicle> vlist = new ArrayList<Vehicle>();
		try {
			String sql = "select * from vehicle where cusid = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cusid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Vehicle v = new Vehicle();
				v.setVin(rs.getString("vin"));
				v.setMake(rs.getString("make"));
				v.setModel(rs.getString("model"));
				v.setType(rs.getString("type"));
				v.setYear(rs.getInt("year"));
				v.setPicture(rs.getString("picture"));
				v.setAmount(rs.getDouble("amount"));
				v.setCusid(rs.getInt("cusid"));
				vlist.add(v);
			}
			ps.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return vlist;
	}
		
	public static boolean insertVehicle(Vehicle v, int cusid) {
		con = ConnectionManager.getConnection();
		boolean flag = false;
		try {
			String sql = "insert into vehicle (vin, make, model, type, year, picture, amount, cusid) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getVin());
			ps.setString(2, v.getMake());
			ps.setString(3, v.getModel());
			ps.setString(4, v.getType());
			ps.setInt(5, v.getYear());
			ps.setString(6, v.getPicture());
			ps.setDouble(7, v.getAmount());
			ps.setInt(8, v.getCusid());
			int val = ps.executeUpdate();
			if (val > 0) {
				flag = true;
			} else  {
				flag = false;
			}
			ps.close();
			con.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	public static boolean editVehicle(Vehicle v) {
		con = ConnectionManager.getConnection();
		boolean flag = false;
		try {
			String sql = "update vehicle set make = ?, model = ?, type = ?, year = ?, picture = ?, amount = ? where vin = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, v.getMake());
			ps.setString(2, v.getModel());
			ps.setString(3, v.getType());
			ps.setInt(4, v.getYear());
			ps.setString(5, v.getPicture());
			ps.setDouble(6, v.getAmount());
			ps.setString(7, v.getVin());
			int val = ps.executeUpdate();
			if (val > 0) {
				flag = true;
			} else  {
				flag = false;
			}
			ps.close();
			con.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;	
	}
	
	public static boolean deleteVehicleByVin(String vin) {
		con = ConnectionManager.getConnection();
		boolean flag = false;
		try {
			String sql = "delete from vehicle where vin = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, vin);
			int val = ps.executeUpdate();
			if (val > 0) {
				flag = true;
			} else  {
				flag = false;
			}
			ps.close();
			con.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteVehicleByCusid(int cusid) {
		con = ConnectionManager.getConnection();
		boolean flag = false;
		try {
			String sql = "delete from vehicle where cusid = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cusid);
			int val = ps.executeUpdate();
			if (val > 0) {
				flag = true;
			} else  {
				flag = false;
			}
			ps.close();
			con.close(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
}
