<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ben's Car Insurance | Vehicle List</title>
</head>
<body>
	<div align="center">
		<h1>Vehicle List</h1>
		<h3><a href="addVehicle">Add New Vehicle</a></h3>	
		<table border="1">
		<tr>
			<th>ID</th>
			<th>VIN</th>
			<th>Make</th>
			<th>Model</th>
			<th>Type</th>
			<th>Year</th>
			<th>Picture</th>
			<th>Amount</th>
			<th>Action</th>
		</tr>	
		<c:forEach var="vehicle" items="${vhcList}" varStatus="status">
		<tr>
			<td>${status.index + 1}</td>
			<td>${vehicle.vin}</td>
			<td>${vehicle.make}</td>
			<td>${vehicle.model}</td>
			<td>${vehicle.type}</td>
			<td>${vehicle.year}</td>
			<td><img src="${vehicle.picture}" width="400" /></td>
			<td>${vehicle.amount}</td>
			<td>	
				<a href="editVehicle?vin=${vehicle.vin}">Edit</a>
				&nbsp;&nbsp;&nbsp;
				<a href="deleteVehicle?vin=${vehicle.vin}">Delete</a>
			</td>
		</tr>
		</c:forEach>
		</table>
		<br /><br />
		<a href="CustomerList">Back to Customer List page</a>
	</div>
</body>
</html>