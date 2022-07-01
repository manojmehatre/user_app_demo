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
import java.sql.*;

import com.user_app_demo.models.DatabaseConnection;
import com.user_app_demo.models.User;

@WebServlet("/userReg")
public class userRegistarationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public userRegistarationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/userRegistration.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session.getAttribute("emailid") != null) {
			String firstName = request.getParameter("firstname");
			String lastName = request.getParameter("lastname");
			String emailId = request.getParameter("emailId");
			String city = request.getParameter("city");
			try {
				DatabaseConnection dbConnection = new DatabaseConnection();
				Connection con = dbConnection.establishConnection();
				User user = new User();
				user.addRegistration(firstName, lastName, emailId, city, con);

				request.setAttribute("msg", "Data Saved");

				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/userRegistration.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
                 e.printStackTrace();
			}

		}
	}

}
