<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
		<form method="post" action="ShowCustomers">
		<table>
			<tr><td>List All Customers: </td><td><input type="submit" name="action" value="show"></td></tr>	
		</table>
		</form>	
	</div>
</body>
</html>