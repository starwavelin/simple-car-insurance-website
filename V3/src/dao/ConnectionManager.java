package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import common.IConstant;

public class ConnectionManager {
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(IConstant.DRIVER);
			con = DriverManager.getConnection(IConstant.URL,
					IConstant.USER, IConstant.PWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
