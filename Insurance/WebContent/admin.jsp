<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.bean.Customer" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin View</title>
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
			
			<c:forEach items="${customers}" var="customer">
			<tr>
				<td><c:out value="${customer.id}"/></td>
				<td><c:out value="${customer.firstname}"/></td>
				<td><c:out value="${customer.lastname}"/></td>
				<td><c:out value="${customer.policyno}"/></td>
				<td><c:out value="${customer.phone}"/></td>
				<td><c:out value="${customer.email}"/></td>
				<td><c:out value="${customer.aaa}"/></td>
			</tr>
			</c:forEach>
			
		</table>	
	</div>
</body>
</html>