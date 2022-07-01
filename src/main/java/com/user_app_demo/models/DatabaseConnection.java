package com.user_app_demo.models;

import java.sql.*;

public class DatabaseConnection {
	private Connection con;

	public Connection establishConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_1","root","test");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
