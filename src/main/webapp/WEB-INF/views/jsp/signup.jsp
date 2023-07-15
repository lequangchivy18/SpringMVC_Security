<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>SIGN UP</h1>
	<form:form action="signup" method="post" modelAttribute="UserDto">
	    <form:input type="text" name="username" placeholder="Username" path="username"/>
	    <p style="color: red;"><form:errors path="username" /></p>
	    <form:input type="password" name="password" placeholder="Password" path="password"/>
	    <p style="color: red;"><form:errors path="password" /></p>
	    <input type="submit" value="Sign Up"/>
	    <a href="login">Back</a>
	</form:form>
</body>
</html>