<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    <%@ page isELIgnored="false" %>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<br>
<h3>${love. user_name} + ${love.crush_name } = ${love.result }</h3>
<br>To save result in email : 
<a href="register">register</a>
<a href="login">login</a>
</div>


</body>
</html>