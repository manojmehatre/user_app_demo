<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ include file="menu.jsp"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/table.css">
<meta charset="ISO-8859-1">
<title>Show Registration</title>
</head>
<body>
	<h2>User Registration Details</h2>
	<table id="customers">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email Id</th>
			<th>City</th>
			<th><a>Delete</a></th>
			<th><a>Update</a></th>
		</tr>

		<% ResultSet results = (ResultSet)request.getAttribute("results");
          while(results.next()){ %>
		<tr>
			<td>
				<% out.println(results.getString(1));%>
			</td>
			<td>
				<% out.println(results.getString(2));%>
			</td>
			<td>
				<% out.println(results.getString(3));%>
			</td>
			<td>
				<% out.println(results.getString(4));%>
			</td>
			<td><a
				href="deleteController?emailid=<% out.println(results.getString(3));%>">Delete</a></td>
			<td><a
				href="updateController?emailid=<% out.println(results.getString(3));%>&city=<% out.println(results.getString(4));%>">Update</a></td>
		</tr>

		<%} %>

	</table>
</body>
</html>