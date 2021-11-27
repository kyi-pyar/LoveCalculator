<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Love Calculator</title>
<style type="text/css">
.error{
color:red;
}

</style>
</head>
<body>
	<marquee>
		<font size="2px">good luck!</font>
	</marquee>
	<div align="center">
		<h2>Love Calculator</h2>
	</div>
	<br>

	<form:form action="calculate" modelAttribute="love">
		<div align="center">
		<label id="yname">Your Name :</label>
		<form:input path="user_name"/> <form:errors path="user_name" class="error"/>
		</div>
		<br>
		<div align="center">
			<label id="cname">Cursh Name:</label>
		<form:input path="crush_name"/><form:errors path="crush_name" class="error"/>
		</div>
		<br>
		<div align="center">
			<input type="submit" value="calculate">&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset">		
		</div>
	</form:form>
</body>
</html>