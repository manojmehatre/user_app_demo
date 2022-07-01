<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/formCss.css">
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
   
   <h3>New Registration</h3>
   <p style="color:red;">
	<%  if(request.getAttribute("msg")!=null){
		out.println(request.getAttribute("msg"));
	}
	 %>
	</p> 
<div class="container">
  <form action="userReg" method="post">
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstname">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname">

    <label for="lname">Email Id</label>
    <input type="text" id="emailId" name="emailId">
    
    <label for="fname">City</label>
    <input type="text" id="city" name="city">

    <input type="submit" value="save">
  </form>
</div>
</body>
</html>