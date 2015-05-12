<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="bean.User, bean.Customer, java.util.*"%>
<%
	User user = (User) session.getAttribute("user");
	String username = user.getUsername();
	List<Customer> clist = (List) session.getAttribute("clist");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car Insurance Site | Admin Page</title>
<link rel="stylesheet" type="text/css"
	href="css/bootstrap/css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/mylayout.css" />
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
			<p>
				Welcome Admin: <strong><%=username%></strong>
			</p>
			<h3>View of All Customers</h3>
			<table width="1100">
				<tr>
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Policy No</th>
					<th>Phone</th>
					<th>Email</th>
					<th>AAA</th>
					<th>Btn1</th>
					<th>Btn2</th>
				</tr>
				<%	for (Customer c : clist) {	%>
				<tr>
					<td><input type="text" name="id" value="<%=c.getId()%>" readonly></td>
					<td><input type="text" name="firstname" value="<%=c.getFirstname()%>"></td>
					<td><input type="text" name="lastname" value="<%=c.getLastname()%>"></td>
					<td><input type="text" name="policyno" value="<%=c.getPolicyno()%>"></td>
					<td><input type="text" name="phone" value="<%=c.getPhone()%>"></td>
					<td><input type="text" name="email" value="<%=c.getEmail()%>"></td>
					<td><input type="text" name="aaa" value="<%=c.getAaa()%>"></td>
					<td><input type="submit" name="btn" value="Edit" /></td>
					<td><input type="submit" name="btn" value="Delete" /></td>
				</tr>
				<%	} %>
				<tr>
					<td><input type="text" id="id_add" value="Auto Increment"
						readonly /></td>
					<td><input type="text" id="firstname_add" /></td>
					<td><input type="text" id="lastname_add" /></td>
					<td><input type="text" id="policyno_add" /></td>
					<td><input type="text" id="phone_add" /></td>
					<td><input type="text" id="email_add" /></td>
					<td><input type="text" id="aaa_add" /></td>
					<td><input type="submit" id="btn_add" name="btn" value="Add" /></td>
				</tr>
			</table>
			
			<h3>View A Customer's Vehicles by Customer ID</h3>
				<form method="post" action="ShowVehicleServlet">
				Please input an ID of a customer to view
				his/her vehicles: <input type="text" name="id">
				<input type="submit" name="btn" value="Show Vehicles">
			</form>
		</div>
	</div>
	
	<script>
		$('#btn_add').click(function(){
			$.post(
				"http://localhost:8080/V3/UpdateCustomerServlet",
				{	
					"btn": "Add",
					"id": $('#id_add').val(),
					"firstname": $('#firstname_add').val(),
					"lastname": $('#lastname_add').val(),
					"policyno": $('#policyno_add').val(),
					"phone": $('#phone_add').val(),
					"email": $('#email_add').val(),
					"aaa": $('#aaa_add').val()
				},
				function() {
					window.location.href="admin.jsp"; 
				}
			);
		});
	</script>

	<script>
		$("td input[value='Edit']").click(function(){
			var tr = $(this).closest('tr');
			//alert(tr.find("[name='firstname']").val());
			$.post(
				"http://localhost:8080/V3/UpdateCustomerServlet",
				{	
					"btn": "Edit",
					"id": tr.find("[name='id']").val(),
					"firstname": tr.find("[name='firstname']").val(),
					"lastname": tr.find("[name='lastname']").val(),
					"policyno": tr.find("[name='policyno']").val(),
					"phone": tr.find("[name='phone']").val(),
					"email": tr.find("[name='email']").val(),
					"aaa": tr.find("[name='aaa']").val()
				},
				/* function(data) {
					alert(data);
				} */
				function() {
					window.location.href="admin.jsp"; 
				}
			);
		});
	</script>	
	
	<script>
		$("td input[value='Delete']").click(function(){
			var tr = $(this).closest("tr");
			$.post(
				"http://localhost:8080/V3/UpdateCustomerServlet",
				{
					"btn": "Delete",
					"id": tr.find("[name='id']").val()
				},
				function() {
					window.location.href="admin.jsp"; 
				}
			);			
		});
	</script>

</body>
</html>