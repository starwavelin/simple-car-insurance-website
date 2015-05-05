package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.User;


public class Dao {
	
	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	public static User login(User u) {
		conn = ConnectionManager.getConnection();
		String username = u.getUsername();
		String password = u.getPassword();
		try {
			String sql = "select * from admin where username = ? and password = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			boolean flag = rs.next();
			if (!flag) {
				System.out.println(username + " has login error!!");
				u.setValid(false);
			} else {
				System.out.println(username + " loginned successfully.");
				u.setValid(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
}
