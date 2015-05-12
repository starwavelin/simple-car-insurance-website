package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestConnection {
	public static void main(String[] args) {
		String username = "joy";
		String password = "1234";
		
		Connection conn = ConnectionManager.getConnection();
		try {
			String sql = "insert into admin (username, password) values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			int val = ps.executeUpdate();
			if (val == 1) {
				String info = "".format("Admin %s is added to DB", username);
				System.out.println(info);
			} else {
				System.out.println("Check Connection!");
			}
			ps.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
