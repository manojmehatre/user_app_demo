<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/formCss.css">
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h3>Login Form</h3>
	<p style="color: red;">
		<%
		if (request.getAttribute("erroMsg") != null) {
			out.println(request.getAttribute("erroMsg"));
		}
		%>
	</p>
	<br />

	<form action="loginController" method="post">

		<label for="fname">Email Id</label> 
		<input type="text" id="email" name="emailId" placeholder="Enter your email id.."> 
		
		<label for="lname">Password</label> 
		<input type="password" id="pwd" name="password" placeholder="Enter your password.."> 
		
		<input type="submit" value="Submit">

	</form>

</body>
</html>