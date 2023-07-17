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
<h1>Change Password</h1>
	<form:form action="savePassword" method="post" modelAttribute="changePass">
	 <input type="hidden" name="csrf_token" value="{{ csrf_token() }}"/>
	
	  <label for="current_password">Current Password</label>
	  <form:input type="password" id="current_password" name="oldPassword" path= "oldPassword"/>
	  <c:if test="${param.invalidPassword != null}">		
		<i style="color: red">Invalid old password</i>
	  </c:if>
	  <p style="color: red;"><form:errors path="oldPassword"/></p>
	  
	  <br/>
	  <label for="new_password">New Password</label>
	  <form:input type="password" id="new_password" name="newPassword" path = "newPassword"/>
	  <p style="color: red;"><form:errors path="newPassword" /></p>
	  <br/>
	
	  <label for="confirm_password">Confirm Password</label>
	  <form:input type="password" id="confirm_password" name="confirmPassword" path = "confirmPassword"/>
	  <c:if test="${param.notMatched != null}">		
		<i style="color: red">Invalid old password</i>
	  </c:if>
	  <p style="color: red;"><form:errors path="newPassword" /></p>
	  <br/>
	
	  <button type="submit">Change Password</button>
	</form:form>
</body>
</html>