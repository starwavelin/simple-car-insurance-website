package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import common.IConstant;

public class ConnectionManager {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(IConstant.DB_DRIVER);
			con = DriverManager.getConnection(IConstant.DB_URL, IConstant.DB_USER, IConstant.DB_PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
