<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Get Employee details by Email Id</h4>
<br>
<br>
<c:if test="${notsuccess }">
	<div>No Employee found, try with another email id</div>
</c:if>
<br>
<br>

<form action="employeedetailsform" method="post">
	Enter Employee email id:<input type="text" name="email">
	<input type="submit" value="Submit">
</form>
</body>
</html>