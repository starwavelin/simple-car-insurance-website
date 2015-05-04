<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ben's Car Insurance Site | Login Page</title>
</head>
<body>
	<div align="center">
		<form id="loginForm" method="post" action="LoginServlet">
			Username: <input type="text" id="username" name="username" />
			Password: <input type="text" id="password" name="password" />
			<input type="submit" name="btn" value="Login" />
		</form>
	</div>
</body>
</html>