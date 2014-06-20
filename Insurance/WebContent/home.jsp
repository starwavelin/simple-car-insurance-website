<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %> 
<%@ page import="com.bean.*;" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display of All Customers</title>
<style>
	table, tr, th, td{border: 1px solid black;}
</style>
</head>
<body>
	<div align="center"> 
		<h1>Customers</h1>
		<table>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Policy No</th>
				<th>Phone</th>
				<th>Email</th>
				<th>AAA Member No</th>				
			</tr>			
			<%
				List<Customer> customers = (List) session.getAttribute("customerList");
				for (Customer c : customers) {
			%>
			<tr>
				<td><%= c.getID() %></td>
				<td><%= c.getFirstname() %></td>
				<td><%= c.getLastname() %></td>
				<td><%= c.getPolicyNo() %></td>
				<td><%= c.getPhone() %></td>
				<td><%= c.getEmail() %></td>
				<td><%= c.getAAA() %></td>
			</tr>
			<% 
				}
			%>
		</table>	
	</div>
</body>
</html>