<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New Registration</title>
</head>
<body>
<h4>Employee Registration Form</h4>

<c:if test="${notsuccess}">
<div style="color:red;"> Registration failed, please try again </div>
</c:if>

<form action="register" method="post"><br>
	 Name: <input type="text" name="name"><br>
	 Email: <input type="text" name="email"><br>
	password: <input type="password" name="password"><br>
	<input type="submit" value="Submit">
</form>

</body>
</html>