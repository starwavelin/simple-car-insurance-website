<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Car Insurance Site | Login Page</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap/css/bootstrap.css" />
<script src="jquery-1.11.2.min.js"></script>
</head>
<body>
	<div class="jumbotron">
		<div class="container">
			<form id="loginForm" name="loginForm" action="LoginServlet" method="post">
				<p>Username: <input type="text" id="username" name="username" /></p>
				<p>Password: <input type="password" id="password" name="password" /></p>
				<p><input type="submit" id="btn_sbt" name="btn_sbt" value="Login"></p>
			</form>
		</div>
	</div>
</body>
</html>