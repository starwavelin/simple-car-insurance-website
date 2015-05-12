package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import bean.Customer;
import bean.User;
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
				u.setValid(true);
			} else {
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
				c.setId(rs.getInt("id"));
				c.setFirstname(rs.getString("firstname"));
				c.setLastname(rs.getString("lastname"));
				c.setPolicyno(rs.getString("policyno"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setAaa(rs.getString("aaa"));
				cList.add(c);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	public static Customer getCustomerByID(int id) {
		con = ConnectionManager.getConnection();
		Customer c = new Customer();
		try {
			String sql = "select * from customer where id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			//System.out.println("Here id is " + id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {		//though we have only 1 record turning out, don't forget use while(rs.next()) to move the cursor
								//to the beginning of the record we want!!!
				c.setId(rs.getInt("id"));
				c.setFirstname(rs.getString("firstname"));
				c.setLastname(rs.getString("lastname"));
				c.setPolicyno(rs.getString("policyno"));
				c.setPhone(rs.getString("phone"));
				c.setEmail(rs.getString("email"));
				c.setAaa(rs.getString("aaa"));
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
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
			ps.setString(3, c.getPolicyno());
			ps.setString(4, c.getPhone());
			ps.setString(5, c.getEmail());
			ps.setString(6, c.getAaa());
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
			ps.setString(3, c.getPolicyno());
			ps.setString(4, c.getPhone());
			ps.setString(5 ,c.getEmail());
			ps.setString(6, c.getAaa());
			ps.setInt(7, c.getId());
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
	
	public static List<Vehicle> getVehicleListByCusid(int cusid) {
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
				v.setYear(rs.getString("year"));
				v.setPicture(rs.getString("picture"));
				v.setAmount(rs.getString("amount"));
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
			ps.setString(5, v.getYear());
			ps.setString(6, v.getPicture());
			ps.setString(7, v.getAmount());
			ps.setInt(8, cusid);
			//System.out.println("Here v.getCusid() is " + v.getCusid());
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
			ps.setString(4, v.getYear());
			ps.setString(5, v.getPicture());
			ps.setString(6, v.getAmount());
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
