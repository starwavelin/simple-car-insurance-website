<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ben's Car Insurance | Add Vehicle</title>
</head>
<body>
	<div align="center">
		<form:form name="formVhc" action="saveInsertVehicle" 
			method="post" modelAttribute="vehicle" onsubmit="return checkVhc(this);">
		<h1>Add Vehicle for Customer ID 
			[<input name="cusid" value="<%=request.getParameter("cusid") %>" size="1" readonly/>]
		</h1>
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
<script>
function checkVhc(v) {
	var re = /^[A-Za-z0-9]+$/;

	var vin = formVhc.vin.value; // formName.inputName.value
	if (vin == "") {
		alert("Please fill the VIN!");
		return false;
	}
	if (!(vin == "") && !re.test(vin)) {
		alert("VIN should contain alphabets and digits only!");
		return false;
	}

	var make = formVhc.make.value;
	if (make == "") {
		alert("Please fill the Make!");
		return false;
	}
	if (!(make == "") && !re.test(make)) {
		alert("Make should contain alphabets and digits only!");
		return false;
	}

	var model = formVhc.model.value;
	if (model == "") {
		alert("Please fill the Model!");
		return false;
	}
	if (!(model == "") && !re.test(model)) {
		alert("Model should contain alphabets and digits only!");
		return false;
	}

	var type = formVhc.type.value;
	if (type == "") {
		alert("Please fill the Type!");
		return false;
	}
	re = /^[A-Za-z_]+$/;
	if (!(type == "") && !re.test(type)) {
		alert("Type should contain alphabets only!");
		return false;
	}

	var year = formVhc.year.value;
	if (year == "") {
		alert("Please fill the Year!");
		return false;
	}
	re = /^(19|20)\d{2}$/;
	if (!(year == "") && !re.test(year)) {
		alert("Year should be between 1900 and 2099!");
		return false;
	}

	var amount = formVhc.amount.value;
	if (amount == "") {
		alert("Please fill the Amount!");
		return false;
	}
	re = /^[0-9]+(.[0-9]{2})?$/;
	if (!(amount == "") && !re.test(amount)) {
		alert("Amount shoudl be a positive decimal value with at most two decimal places!");
		return false;
	}

	return true;
}
</script>	
</body>
</html>