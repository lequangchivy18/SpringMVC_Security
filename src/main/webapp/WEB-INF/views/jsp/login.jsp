<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>My custom login page</h1>
	<c:if test="${param.error != null}">		
		<i style="color: red">Invalid username or password</i>
	</c:if>
	<c:if test="${param.logout != null}">		
		<i style="color: green">Logout success</i>
	</c:if>
	<c:if test="${param.success != null}">		
		<i style="color: green">Signup success</i>
	</c:if>
	<form:form class="form-signin" method="post" action="process-login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <a href="signup">Signup</a>
      </form:form>
</body>
</html>