<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Vehicle" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Vehicle</title>
</head>
<body>
<%
	String cusid = session.getAttribute("cusid").toString(); 
%>
	<div align="center">
		<h1>Customer ID <%=cusid %>'s Vehicles</h1>
		<table>
			<tr>
				<th>VIN</th>
				<th>Make</th>
				<th>Model</th>
				<th>Type</th>
				<th>Year</th>
				<th>Picture</th>
				<th>Amount</th>
				<th>Customer ID</th>				
			</tr>
			<%
				List<Vehicle> vehicles = (List) session.getAttribute("vehicleList");				
				for (Vehicle v : vehicles) {
			%>
			<tr>
				<td><%=v.getVin()%></td>
				<td><%=v.getMake()%></td>
				<td><%=v.getModel()%></td>
				<td><%=v.getType()%></td>
				<td><%=v.getYear()%></td>
				<td><img src="<%=v.getPicture()%>" width="100" /></td>
				<td><%=v.getAmount()%></td>
				<td><%=v.getCusid()%></td>				
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>