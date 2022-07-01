package com.user_app_demo.models;

import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;

public class Login {

	private Connection con;
	private Statement stmnt;
	private ResultSet result;

	public boolean verifyLogin(String emailId, String password, Connection con) {
		try {
			stmnt = con.createStatement();
			result = stmnt.executeQuery(
					"select * from login where emailid='" + emailId + "' and password='" + password + "'");
			return result.next();

		} catch (Exception e) {
			return false;
		}

	}

	/*
	 * public void destroy() {
	 * 
	 * }
	 */
}
