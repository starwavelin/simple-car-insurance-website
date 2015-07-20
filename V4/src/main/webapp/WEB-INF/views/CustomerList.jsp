<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ben's Car Insurance | Customer List</title>
</head>
<body>
	<div align="center">
		<h1>Customer List</h1>
		<h3><a href="addCustomer">Add New Customer</a></h3>	
				<!-- Should set href as "addCustomer" rather than "/addCustomer";
				if using "/addCustomer", it sets the root directory to "/addCustomer" -->
		<table border="1">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Policy No</th>
			<th>Phone</th>
			<th>Email</th>
			<th>AAA</th>
			<th>Action</th>
		</tr>	
		<c:forEach var="customer" items="${cusList}" varStatus="status">
		<tr>
			<td>${status.index + 1}</td>
			<td>${customer.firstname}</td>
			<td>${customer.lastname}</td>
			<td>${customer.policyno}</td>
			<td>${customer.phone}</td>
			<td>${customer.email}</td>
			<td>${customer.aaa}</td>
			<td>
				<a href="editCustomer?id=${customer.id}">Edit</a>
				&nbsp;&nbsp;&nbsp;
				<a href="deleteCustomer?id=${customer.id}">Delete</a>
				&nbsp;&nbsp;&nbsp;
				<a href="VehicleList?id=${customer.id}">Show his/her vehicles</a>
			</td>
		</tr>
		</c:forEach>
		</table>
	</div>
</body>
</html>