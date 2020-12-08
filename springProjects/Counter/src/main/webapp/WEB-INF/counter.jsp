
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>

<html>

	<head>
	
		<meta charset="UTF-8">
		<title>Home</title>
	
		<script src=""></script>
	
		<link rel="stylesheet" href="">
	
	
	</head>

	<body>
	
		<h2>You have visited <a href="/your_server/">Home Page </a><c:out value="${count}"></c:out> times.</h2>
	
		<h2><a href="/your_server/clear">Clear Session Count</a></h2>
		
		
	</body>


</html>