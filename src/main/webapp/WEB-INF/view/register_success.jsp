<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  %>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h2> Success....</h2>
<h4>Would you like to send the result in your mail</h4><br>

<h3> ${sessionScope.loveUser.email }</h3>
</div>
<form:form action="send_mail">
<div align="center">
<input type="submit" value="send" name="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" value="try_again" name="try_again">
</div>
</form:form>


</body>
</html>