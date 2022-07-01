package com.user_app_demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;

import com.user_app_demo.models.DatabaseConnection;
import com.user_app_demo.models.User;

@WebServlet("/showUser")
public class ShowUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShowUserController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("emailid")!=null) {     
		try {
				DatabaseConnection db=new DatabaseConnection();
				Connection con = db.establishConnection();
	        	User user=new User();
	        	ResultSet results = user.showRegistration(con);
	        	request.setAttribute("results", results);
	        	
	        	RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showReg.jsp");
				rd.forward(request, response);	
			} catch (Exception e) {
				
				
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
	}

}
