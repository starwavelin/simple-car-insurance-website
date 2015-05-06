<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="bean.User, java.util.List, bean.Customer"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ben's Car Insurance Site | Admin Page</title>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/mylayout.css" rel="stylesheet">
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
		String username = user.getUsername();
		
		List<Customer> clist = (List) session.getAttribute("clist");
	%>
	<h4 align="right">
		<form method="get" action="LogoutServlet">
			<input type="submit" name="btn" value="Logout">
		</form>
	</h4>
	<div class="jumbotron">
		<div class="container">
			<h3>Welcome <%= username %></h3>
			<h3>View of All Customers</h3>
			<table>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Policy No</th>
					<th>Phone</th>
					<th>Email</th>
					<th>AAA</th>
				</tr>
				<% for (Customer c : clist) { %>
				<tr>
					<td><%=c.getID() %></td>
					<td><%=c.getFirstname() %></td>
					<td><%=c.getLastname() %></td>
					<td><%=c.getPolicyNo() %></td>
					<td><%=c.getPhone() %></td>
					<td><%=c.getEmail() %></td>
					<td><%=c.getAAA() %></td>
				</tr>
				<% } %>
			</table>
			
			<form method="post" action="UpdateCustomerServlet">
			<h3>Add Customer</h3>
			<table>
				<tr>
					
					<th>First Name</th>
					<th>Last Name</th>
					<th>Policy No</th>
					<th>Phone</th>
					<th>Email</th>
					<th>AAA</th>
					<th>&nbsp;</th>
				</tr>
				<tr><td colspan="7">
				** Add new customer: the ID of the new customer will be the current last ID + 1. **
				</td></tr>
				<tr>
					
					<td><input type="text" name="firstname"></td>
					<td><input type="text" name="lastname"></td>
					<td><input type="text" name="policyno"></td>
					<td><input type="text" name="phone"></td>
					<td><input type="text" name="email"></td>
					<td><input type="text" name="aaa"></td>
					<td><input type="submit" name="btn" value="Add"></td>
				</tr>
			</table>
			
			<h3>Edit Customer</h3>
			<table>
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Policy No</th>
					<th>Phone</th>
					<th>Email</th>
					<th>AAA</th>
					<th>&nbsp;</th>
				</tr>
				<tr><td colspan="8">
				** Select an existed customer to edit: 
				make sure the customer ID is an existed one. **
				</td></tr>
				<tr>
					<td><input type="text" name="id"></td>
					<td><input type="text" name="firstname"></td>
					<td><input type="text" name="lastname"></td>
					<td><input type="text" name="policyno"></td>
					<td><input type="text" name="phone"></td>
					<td><input type="text" name="email"></td>
					<td><input type="text" name="aaa"></td>
					<td><input type="submit" name="btn" value="Edit"></td>
				</tr>
			</table>
			
			<h3>Delete Customer</h3>
			Please input an ID of a customer to be removed: 
			<input type="text" name="id">
			<input type="submit" name="btn" value="Delete"> 
			</form>
			
			
			<h3>View A Customer's Vehicles by Customer ID</h3>
			<form method="post" action="ShowVehiclesServlet">
			Please input an ID of a customer to view
			his/her vehicles: <input type="text" name="id">
			<input type="submit" name="btn" value="Show Vehicles">
			</form>
		</div>
	</div>
</body>
</html>