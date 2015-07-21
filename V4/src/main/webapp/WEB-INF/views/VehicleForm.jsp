<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ben's Car Insurance | Add/Edit Vehicle</title>
</head>
<body>
	<div align="center">
		<form:form action="saveVehicle" method="post" modelAttribute="vehicle">
		<h1>Add/Edit Vehicle for Customer ID [<form:input path="cusid" width="2" />]</h1>
		<label>*Note: do not change VIN if you are editing an vehicle info</label>
		<table>
			<tr>
                <td>VIN:</td>
                <td><form:input path="vin" /></td>
            </tr>
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