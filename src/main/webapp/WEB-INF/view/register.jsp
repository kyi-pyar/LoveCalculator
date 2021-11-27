<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div align="center"><h2>Registration</h2></div>
<form:form action="registered" method="post" modelAttribute="loveUser">
<div align="center">
<label> Email:   </label>
<form:input path="email"/><form:errors path="email" class="error"/>
</div><br>
<div align="center">
<label> Password:   </label>
<form:password path="password"/>
</div><br>
<div align="center">
<input type="submit"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset">
</div>
</form:form>

</body>
</html>