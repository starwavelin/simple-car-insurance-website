<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ben's Car Insurance | Edit Vehicle</title>
</head>
<body>
	<div align="center">
		<form:form action="saveUpdateVehicle" method="post" modelAttribute="vehicle">
		<h1>
			Edit Vehicle for Vehicle VIN [<form:input path="vin" size="2" />]
			of Customer ID [<form:input path="cusid" size="1" />]
		</h1>
		<table>
            <tr>
                <td>Make:</td>
                <td><form:input path="make" /></td>
            </tr>
            <tr>
                <td>Model:</td>
                <td><form:input path="model" /></td>
            </tr>
            <tr>
                <td>Type:</td>
                <td><form:input path="type" /></td>
            </tr>
            <tr>
                <td>Year:</td>
                <td><form:input path="year" /></td>
            </tr>
            <tr>
                <td>Picture:</td>
                <td><form:input path="picture" /></td>
            </tr>
            <tr>
                <td>Amount:</td>
                <td><form:input path="amount" /></td>
            </tr>
            <tr>
            	<td colspan="2" align="center"><input type="submit" value="Save" /></td>
            </tr>
		</table>
		</form:form>
	</div>
</body>
</html>