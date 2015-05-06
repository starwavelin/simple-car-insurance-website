<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ben's Car Insurance Site | Login Page</title>
<link href="css/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
	<div class="jumbotron">
		<div class="container">
		<h3>Ben's Car Insurance Site | Login Page</h3>
		<form id="loginForm" method="post" action="LoginServlet">
			User name: <input type="text" id="username" name="username" />
			Password: <input type="password" id="password" name="password" />
			<input type="submit" name="btn" value="Login" />
		</form>
		</div>
	</div>
</body>
</html>