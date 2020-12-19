<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Event</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	
</head>
<body>
	
	<a href="/home">Return Home</a>
	<h1>Edit <c:out value="${event.name}"/>:</h1>
	
	<hr>
	
	<form:form action="/update_event/${event.id}" method="post" modelAttribute="event">
	
		<p>
			Name:
			<form:input path="name" value="${event.name}"/>
			<form:errors path="name"/>
		</p>
		
		<p>
			Date:
			<form:input type="date" path="date"/>
		</p>
		
		<p>
			Location:
			<form:input path="location" value="${event.location}"/>
			<form:errors path="location"/>
		</p>
		
		<p>
			State:
			<form:input path="state" value="${event.state}"/>
		</p>
		<button type="submit">Create Event</button>
	
	</form:form>


</body>
</html>