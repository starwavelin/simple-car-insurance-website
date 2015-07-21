<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ben's Car Insurance | Add/Edit Customer</title>
</head>
<body>
	<div align="center">
		<h1>Add/Edit Customer</h1>
		<form:form action="saveCustomer" method="post" modelAttribute="customer">
		<table>
			<form:hidden path="id" />
			<tr>
                <td>First Name:</td>
                <td><form:input path="firstname" /></td>
            </tr>
            <tr>
                <td>Last Name:</td>
                <td><form:input path="lastname" /></td>
            </tr>
            <tr>
                <td>Policy No:</td>
                <td><form:input path="policyno" /></td>
            </tr>
            <tr>
                <td>Phone:</td>
                <td><form:input path="phone" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>AAA:</td>
                <td><form:input path="aaa" /></td>
            </tr>
            <tr>
            	<td colspan="2" align="center"><input type="submit" value="Save" /></td>
            </tr>
		</table>
		</form:form>
	</div>
</body>
</html>