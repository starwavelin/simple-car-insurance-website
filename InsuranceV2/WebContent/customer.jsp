<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="bean.User, java.util.List, bean.Customer, bean.Vehicle"
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
		
		Customer cus = (Customer) session.getAttribute("cus");
		List<Vehicle> vlist = (List) session.getAttribute("vlist");
	%>
	<h4 align="right">
		<form method="get" action="LogoutServlet">
			<input type="submit" name="btn" value="Logout">
		</form>
	</h4>
	<div class="jumbotron">
		<div class="container">
			<h3>Welcome <%= username %></h3>
			<h3>Current Customer's Information</h3>
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
				<tr>
					<td><%=cus.getID() %></td>
					<td><%=cus.getFirstname() %></td>
					<td><%=cus.getLastname() %></td>
					<td><%=cus.getPolicyNo() %></td>
					<td><%=cus.getPhone() %></td>
					<td><%=cus.getEmail() %></td>
					<td><%=cus.getAAA() %></td>
				</tr>
			</table>
			
			<h3>View of All Vehicles He/She Has</h3>
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
				<% for (Vehicle v : vlist) { %>
				<tr>
					<td><%=v.getVin() %></td>
					<td><%=v.getMake() %></td>
					<td><%=v.getModel() %></td>
					<td><%=v.getType() %></td>
					<td><%=v.getYear() %></td>
					<td><img src="<%=v.getPicture() %>" width="100"></td>
					<td><%=v.getAmount() %></td>
					<td><%=v.getCusid() %></td>
				</tr>
				<% } %>
			</table>
			
			<form method="post" action="UpdateVehicleServlet">
			<h3>Add Vehicle</h3>
			<table>
				<tr>
					<th>VIN</th>
					<th>Make</th>
					<th>Model</th>
					<th>Type</th>
					<th>Year</th>
					<th>Picture</th>
					<th>Amount</th>
					<th>&nbsp;</th>
				</tr>
				<tr><td colspan="7">
				** Add new vehicle under the current customer. **
				</td></tr>
				<tr>
					<td><input type="text" name="vin"></td>
					<td><input type="text" name="make"></td>
					<td><input type="text" name="model"></td>
					<td><input type="text" name="type"></td>
					<td><input type="text" name="yaer"></td>
					<td><input type="text" name="picture"></td>
					<td><input type="text" name="amount"></td>
					<td><input type="submit" name="btn" value="Add"></td>
				</tr>
			</table>
			
			<h3>Edit Vehicle</h3>
			<table>
				<tr>
					<th>VIN</th>
					<th>Make</th>
					<th>Model</th>
					<th>Type</th>
					<th>Year</th>
					<th>Picture</th>
					<th>Amount</th>
					<th>&nbsp;</th>
				</tr>
				<tr><td colspan="8">
				** Select an existed vehicle to edit: 
				make sure the VIN is an existed one. **
				</td></tr>
				<tr>
					<td><input type="text" name="vin_ed"></td>
					<td><input type="text" name="make_ed"></td>
					<td><input type="text" name="model_ed"></td>
					<td><input type="text" name="type_ed"></td>
					<td><input type="text" name="yaer_ed"></td>
					<td><input type="text" name="picture_ed"></td>
					<td><input type="text" name="amount_ed"></td>
					<td><input type="submit" name="btn" value="Edit"></td>
				</tr>
			</table>
			
			<h3>Delete Vehicle</h3>
			Please input an VIN of a vehicle to be removed: 
			<input type="text" name="vin_del">
			<input type="submit" name="btn" value="Delete"> 
			</form>
			
		</div>
	</div>
</body>
</html>