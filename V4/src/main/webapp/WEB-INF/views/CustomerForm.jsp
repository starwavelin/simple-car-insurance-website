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
		<form:form name="formCus" action="saveCustomer" 
			method="post" modelAttribute="customer" onsubmit="return checkCustomer(this);">
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
	
<script type="text/javascript"> 
	function checkCustomer(c) {
		
		/* The following presents a variety of ways of referring the input field values. */
		
		var firstname = formCus.firstname.value;	// formName.inputName.value
		if (firstname == "") {
			alert("Fill in the first name please!");
			return false;
		}
		
		var lastname = formCus.lastname.value;	
		if (lastname == "") {
			alert("Fill in the last name please!");
			return false;
		}
		
		var policyno = formCus.policyno.value; 
		if (policyno == "") {
			alert("Fill in the policy number please!");
			return false;
		}
		var re = /^[A-Za-z0-9]+$/;
		if (!(policyno == "") && !re.test(policyno)) {
			alert("Policy number should contain alphabets and digits only!");
			return false;
		}
				
				// the ith form and then refer the elements['inputName'] in this form
		var phone = formCus.phone.value;
		if (phone == "") {
			alert("Fill in the phone number please!");
			return false;
		}
		re = /^(\d{3}-\d{3}-\d{4})$/;
		if (!(phone == "") && !re.test(phone)) {
			alert("The phone number should be in format 'xxx-xxx-xxxx'!");
			return false;
		}
		
		var email = formCus.email.value;
		if (email == "") {
			alert("Fill in the email please!");
			return false;
		}
		re = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
		if (!(email == "") && !re.test(email)) {
			alert("Wrong format of email!");
			return false;
		}
		
		return true;
	}
</script>	
</body>
</html>