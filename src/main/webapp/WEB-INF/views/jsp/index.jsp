<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<h1>Spring MVC Hello World!</h1>
	<a href="hello">Hello User</a>
	<a href="admin">Admin</a>
	<br/>
	<a href="deleteUser?userId=${userId}">Delete</a>
	<form:form action="logout">
		<input type="submit" value="logout">
	</form:form>
</body>
</html>
