<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="bean.User, java.util.List, bean.Customer, bean.Vehicle"%>
<%
	User user = (User) session.getAttribute("user");
	String username = user.getUsername();
	Customer cus = (Customer) session.getAttribute("cus");
	List<Vehicle> vlist = (List) session.getAttribute("vlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Car Insurance Site | Customer Page</title>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
<link href="css/mylayout.css" rel="stylesheet">
<script src="jquery-1.11.2.min.js"></script>
</head>
<body>
	<h4 align="right">
		<form method="get" action="LogoutServlet">
			<input type="submit" name="btn" value="Logout">
		</form>
	</h4>
	<div class="jumbotron">
		<div class="container">
			<h3>Welcome	<%=username%></h3>
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
					<td><%=cus.getId()%></td>
					<td><%=cus.getFirstname()%></td>
					<td><%=cus.getLastname()%></td>
					<td><%=cus.getPolicyno()%></td>
					<td><%=cus.getPhone()%></td>
					<td><%=cus.getEmail()%></td>
					<td><%=cus.getAaa()%></td>
				</tr>
			</table>

			<h3>View of All Vehicles He/She Has</h3>
			<table width="1100">
				<tr>
					<th>VIN</th>
					<th>Make</th>
					<th>Model</th>
					<th>Type</th>
					<th>Year</th>
					<th>Picture</th>
					<th>Amount</th>
					<th>CusID</th>
					<th>Btn1</th>
					<th>Btn2</th>
				</tr>
				<%
					for (Vehicle v : vlist) {
				%>
				<tr>
					<td><input type="text" name="vin" value="<%=v.getVin()%>" readonly></td>
					<td><input type="text" name="make" value="<%=v.getMake()%>"></td>
					<td><input type="text" name="model" value="<%=v.getModel()%>"></td>
					<td><input type="text" name="type" value="<%=v.getType()%>"></td>
					<td><input type="text" name="year" value="<%=v.getYear()%>"></td>
					<td>
						<img src="<%=v.getPicture()%>" width="100"><br/>
						<input type="text" name="picture" value="<%=v.getPicture()%>">					
					</td>
					<td><input type="text" name="amount" value="<%=v.getAmount()%>"></td>
					<td><%=v.getCusid()%></td>
					<td><input type="submit" name="btn" value="Edit" /></td>
					<td><input type="submit" name="btn" value="Delete" /></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td><input type="text" id="vin_add"></td>
					<td><input type="text" id="make_add"></td>
					<td><input type="text" id="model_add"></td>
					<td><input type="text" id="type_add"></td>
					<td><input type="text" id="year_add"></td>
					<td><input type="text" id="picture_add"></td>
					<td><input type="text" id="amount_add"></td>
					<td><%=cus.getId()%></td>
					<td><input type="submit" id="btn_add" name="btn" value="Add" /></td>
				</tr>
			</table>
			
			
			<script>
				$('#btn_add').click(function() {
					$.post("http://localhost:8080/V3/UpdateVehicleServlet", {
						"btn" : "Add",
						"vin" : $('#vin_add').val(),
						"make" : $('#make_add').val(),
						"model" : $('#model_add').val(),
						"type" : $('#type_add').val(),
						"year" : $('#year_add').val(),
						"picture" : $('#picture_add').val(),
						"amount" : $('#amount_add').val()
					}, function() {
						window.location.href = "customer.jsp";
					});
				});
			</script>

			<script>
				$("td input[value='Edit']").click(function() {
					var tr = $(this).closest('tr');
					// alert(tr.find("td input[value='Edit']").val());
					$.post("http://localhost:8080/V3/UpdateVehicleServlet", {
						"btn" : "Edit",
						"vin" : tr.find("[name='vin']").val(),
						"make" : tr.find("[name='make']").val(),
						"model" : tr.find("[name='model']").val(),
						"type" : tr.find("[name='type']").val(),
						"year" : tr.find("[name='year']").val(),
						"picture" : tr.find("[name='picture']").val(),
						"amount" : tr.find("[name='amount']").val()
					},
					function() {
						window.location.href = "customer.jsp";
					});
				});
			</script>

			<script>
				$("td input[value='Delete']").click(function() {
					var tr = $(this).closest("tr");
					$.post("http://localhost:8080/V3/UpdateVehicleServlet", {
						"btn" : "Delete",
						"vin" : tr.find("[name='vin']").val()
					}, function() {
						window.location.href = "customer.jsp";
					});
				});
			</script>
		</div>
	</div>
</body>
</html>