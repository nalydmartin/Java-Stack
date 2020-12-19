<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Details</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	
</head>
<body>

	<a href="/home">Go Home</a>

	<hr>
	
	
	<h1><c:out value="${show.name}"/></h1>

	<h3>Network: <c:out value="${show.network}"/></h3>
	
	<h3><c:out value="${show.user.username}'s"/> Rating: <c:out value="${show.rating}"/></h3>
	
	
	<h4><a href="/edit/${show.id}">Edit Show</a></h4>
	<h4><a href="/delete/${show.id}">Delete Show</a></h4>
</body>
</html>