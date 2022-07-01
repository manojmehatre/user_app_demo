package com.user_app_demo.models;

import java.sql.*;



public class User {
    private Statement stmnt;
	public void addRegistration(String firstName,String lastName,String emailId,String city,Connection con) {
		
		try {
			stmnt = con.createStatement();
			stmnt.executeUpdate("insert into user_registration values('"+firstName+"','"+lastName+"','"+emailId+"','"+city+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
	}
	public ResultSet showRegistration(Connection con) {
		try {
			Statement stmnt =con.createStatement();
			ResultSet results = stmnt.executeQuery("select * from user_registration");
			return results;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void deleteReg(String emailId,Connection con) {
		try {
			Statement stmnt =con.createStatement();
			stmnt.executeUpdate("DELETE FROM user_registration WHERE emailid='"+emailId+"'");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void updateReg(String emailId,String city,Connection con) {
		try {
			
			Statement stmnt =con.createStatement();
			stmnt.executeUpdate("update user_registration set city='"+city+"' where emailid='"+emailId+"'");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
