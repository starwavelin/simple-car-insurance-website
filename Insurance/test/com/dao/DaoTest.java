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
		

		// Test Data
		String username = "Jenny";
		String password = "7679";

		try {
			Statement st = Dao.getConnection().createStatement();
			int val = st.executeUpdate
					("INSERT INTO admin (username, password) VALUES ('" + username + "','" + password + "')");
			if (val == 1) {
				System.out.println("(" + username + ", " + password + ")" + "is inserted into admin table.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Dao.getID();

	}

}
