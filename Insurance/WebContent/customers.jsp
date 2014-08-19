<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %> 
<%@ page import="com.bean.Customer;" %>
    
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
		<br />
		<h3>Edit Customer</h3>
		<form name="editCustomer" method="post" action="EditCustomer">
			<table>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Policy No</th>
					<th>Phone</th>
					<th>Email</th>
					<th>AAA Member No</th>
					<th>button</th>
				</tr>	
				<tr><td colspan="8">** Select an existed customer to edit: make sure the customer ID is an existed one. **</td></tr>
				<tr>
					<td><input type="text" name="id" /></td>
					<td><input type="text" name="firstname" /></td>
					<td><input type="text" name="lastname" /></td>
					<td><input type="text" name="policyno" /></td>
					<td><input type="text" name="phone" /></td>
					<td><input type="text" name="email" /></td>
					<td><input type="text" name="aaa" /></td>
					<td><input type="submit" name="edit" value="Update" /></td>
				</tr>
			</table>
		</form>
		<br />
		<h3>Add Customer</h3>
		<form name="addCustomer" method="post" action="AddCustomer">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Policy No</th>
					<th>Phone</th>
					<th>Email</th>
					<th>AAA Member No</th>
					<th>button</th>
				</tr>	
				<tr><td colspan="7">** Add new customer: the ID of the new customer will be the current last ID + 1. **</td></tr>
				<tr>
					<td><input type="text" name="firstname" /></td>
					<td><input type="text" name="lastname" /></td>
					<td><input type="text" name="policyno" /></td>
					<td><input type="text" name="phone" /></td>
					<td><input type="text" name="email" /></td>
					<td><input type="text" name="aaa" /></td>
					<td><input type="submit" name="edit" value="Insert" /></td>
				</tr>
			</table>
		</form>
		<br />
		<h3>View a customer's vehicles by ID</h3>
		<form name="showVehicles" method="post" action="ShowVehicles">
			<p>Please enter an existing customer ID, then click View:
			   <input type="text" name="cusID" />&nbsp;
			   <input type="submit" name="showVehicles" value="ShowVehicles" />		   
			</p>
		</form>			
	</div>
</body>
</html>