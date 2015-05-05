<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="bean.User, java.util.List"
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ben's Car Insurance Site | Admin Page</title>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<%
		User user = (User) session.getAttribute("user");
		String username = user.getUsername();	
	%>
	<h4 align="right">
		<form method="get" action="LogoutServlet">
			<input type="submit" name="btn" value="Logout">
		</form>
	</h4>
	<div class="jumbotron">
		<div class="container">
			<h3>Welcome <%= username %></h3>
		</div>
	</div>
</body>
</html>