<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/formCss.css">
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
   <h2>Update User</h2>
   <p style="color:red;">
   <%
		if (request.getAttribute("updateMsg")!=null) {
			out.println(request.getAttribute("updateMsg"));
		}
		%>
	</p>	
   <div class="container">
    <% if(request.getAttribute("emailid")!=null){ %>
  <form action="updateController" method="post">
  
    <label for="lname">Email Id</label>
    <input type="text" id="emailId" name="emailid" value="<%=request.getAttribute("emailid") %>" readonly>
    
    <label for="fname">City</label>
    <input type="text" id="city" name="city" value="<%= request.getAttribute("city")%>">
    <input type="submit" value="Update">
   
  </form>
   <%} %>
</div>    

</body>
</html>