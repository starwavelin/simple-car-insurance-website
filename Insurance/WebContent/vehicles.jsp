<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.bean.Vehicle" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Vehicle</title>
<style>
	table, th, tr, td{border: 1px solid black;}
</style>
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
		<br />
		<h3>Edit Vehicles for Customer ID <%=cusid %>'s</h3>
		<form name="editVehicle" method="post" action="EditVehicle">
			<table>
				<tr>
					<th>VIN</th>
					<th>Make</th>
					<th>Model</th>
					<th>Type</th>
					<th>Year</th>
					<th>Picture</th>
					<th>Amount</th>
					<th>CustomerID</th>
					<th>Button</th>					
				</tr>
				<tr><td colspan="8">** Select an existed VIN to edit: make sure the vehicle's VIN is an existed one. **</td></tr>
				<tr>
					<td><input type="text" name="vin" /></td>
					<td><input type="text" name="make" /></td>
					<td><input type="text" name="model" /></td>
					<td><input type="text" name="type" /></td>
					<td><input type="text" name="year" /></td>
					<td><input type="text" name="picture" /></td>
					<td><input type="text" name="amount" /></td>
					<td><input type="text" name="cusid" value="<%=cusid %>" /></td>
					<td><input type="submit" name="edit" value="Update"/></td>					
				</tr>
			</table>
		</form>
		<br />
		<h3>Add Vehicles for Customer ID <%=cusid %>'s</h3>
		<form name="addVehicle" method="post" action="AddVehicle">
			<table>
				<tr>
					<th>VIN</th>
					<th>Make</th>
					<th>Model</th>
					<th>Type</th>
					<th>Year</th>
					<th>Picture</th>
					<th>Amount</th>
					<th>CusID</th>					
				</tr>
				<tr>
					<td><input type="text" name="vin" /></td>
					<td><input type="text" name="make" /></td>
					<td><input type="text" name="model" /></td>
					<td><input type="text" name="type" /></td>
					<td><input type="text" name="year" /></td>
					<td><input type="text" name="picture" /></td>
					<td><input type="text" name="amount" /></td>
					<td><input type="text" name="cusid" value="<%=cusid %>" /></td>
					<td><input type="submit" name="edit" value="Add" /></td>					
				</tr>
			</table>
		</form>
	</div>
</body>
</html>