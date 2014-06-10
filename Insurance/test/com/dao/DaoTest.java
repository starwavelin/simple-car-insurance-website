package com.dao;

import java.sql.SQLException;
import java.sql.Statement;


/**
 * Test JDBC Connection
 * @author Guru
 *
 */
public class DaoTest {
	
	public static void main(String [] args) {
		// Set up connection
		Dao dao = new Dao();
		
		// Test Data
		String username = "Jon";
		String password = "3333";
		
		try {
			Statement st = dao.getConnection().createStatement();
			int val = st.executeUpdate
					("INSERT INTO admin (username, password) VALUES ('" + username + "','" + password + "')");
			if (val == 1) {
				System.out.println("(" + username + ", " + password + ")" + "is inserted into admin table.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
