package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import common.IConstant;

public class ConnectionManager {
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(IConstant.DB_DRIVER);
			conn = DriverManager.getConnection(IConstant.DB_URL, IConstant.DB_USER, IConstant.DB_PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}
