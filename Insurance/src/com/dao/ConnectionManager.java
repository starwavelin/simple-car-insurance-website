package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * This class sets up the DB connection
 * @author Benjamin Lin
 * date: Jun 20, 2014
 *
 */
public class ConnectionManager {
	
	private final static String URL = "jdbc:mysql://localhost:3306/insurance";	
	private final static String DB_USER = "USE_YOUR_OWN_DB_USER";	
	private final static String DB_PSWD = "USE_YOUR_OWN_DB_USER_PASSWORD"; 
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, DB_USER, DB_PSWD);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
}
