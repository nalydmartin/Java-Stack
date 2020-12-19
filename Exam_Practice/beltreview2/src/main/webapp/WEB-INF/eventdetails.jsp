<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

	<meta charset="UTF-8">
	<title>Event Details</title>
</head>
<body>

	<a href="/home">Go Home</a>

	<h1><c:out value="${event.user.firstName}'s ${event.name}:"/></h1>

	<hr>
	
	<ul>
	
		<li>Date: <c:out value="${event.date}"/></li>
		<li>Location: <c:out value="${event.location}"/></li>
		<li>State: <c:out value="${event.state}"/></li>
	</ul>
	
	





</body>
</html>