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

import com.user_app_demo.models.DatabaseConnection;
import com.user_app_demo.models.Login;
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String emailId = request.getParameter("emailId");
	    String password = request.getParameter("password");
	    Login login=new Login();
	    DatabaseConnection dbConnection=new DatabaseConnection();
	    Connection con = dbConnection.establishConnection();
	    boolean result = login.verifyLogin(emailId, password, con);
	    System.out.println(result);
	    HttpSession session = request.getSession(true);
	    if(result==true) {
	    	session.setAttribute("emailid", emailId);
	    	RequestDispatcher rd1 = request.getRequestDispatcher("WEB-INF/views/userRegistration.jsp");
	        rd1.include(request, response);
	    }else {
	    	
	    	  request.setAttribute("erroMsg","Invalid Username / Password");
	    	  
	    	  RequestDispatcher rd1 = request.getRequestDispatcher("index.jsp");
	          rd1.include(request, response);
	    }
	}

}
