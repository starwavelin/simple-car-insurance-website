package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.User;
import bean.Customer;


public class Dao {
	
	private static Connection conn = null;
	
	public static User login(User u) {
		conn = ConnectionManager.getConnection();
		String username = u.getUsername();
		String password = u.getPassword();
		try {
			String sql = "select * from admin where username = ? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			boolean flag = rs.next();
			if (!flag) {
				System.out.println(username + " has login error!!");
				u.setValid(false);
			} else {
				System.out.println(username + " loginned successfully.");
				u.setValid(true);
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
	public static List<Customer> showCustomerList() {
		conn = ConnectionManager.getConnection();
		List<Customer> cList = new ArrayList<Customer>();
		try {
			String sql = "select * from customer";
			PreparedStatement ps = conn.prepareStatement(sql);
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
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cList;
	}
	
	/*public static int getID() {
		conn = ConnectionManager.getConnection();
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
			conn.close(); 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return id;
	}*/
	
	public static boolean insert(Customer c) {
		conn = ConnectionManager.getConnection();
		boolean flag = false;
			
		try {
			String sql = "insert into customer (firstname, lastname, policyno, phone, email, aaa) "
					+ "values (?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
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
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
}
