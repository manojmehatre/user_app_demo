package com.user_app_demo.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import com.user_app_demo.models.DatabaseConnection;
import com.user_app_demo.models.User;

@WebServlet("/updateController")
public class UpdateUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateUserController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("emailid");
		String city = request.getParameter("city");
		request.setAttribute("emailid", emailId);
		request.setAttribute("city", city);
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/updateReg.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String emailId = request.getParameter("emailid");
		String city = request.getParameter("city");
		try {

			DatabaseConnection dbConnection = new DatabaseConnection();
			Connection con = dbConnection.establishConnection();
			User user = new User();
			user.updateReg(emailId, city, con);
            ResultSet results = user.showRegistration(con);
            request.setAttribute("results", results);
			request.setAttribute("updateMsg", "Record Updated");

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/showReg.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
