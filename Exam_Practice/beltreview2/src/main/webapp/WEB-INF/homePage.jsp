<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>
	<h3>Welcome, <c:out value="${user.firstName} ${user.lastName}" /></h3>
	<a href="/logout">Logout</a>
	
	<hr>
	
		<table class="table table-striped table-bordered">
		
			<thead class="thead-dark">
				
				<tr>
					<th>Name</th>
					<th>Date</th>
					<th>Location</th>
					<th>State</th>
					<th>Host</th>
					<th>Actions</th>
				</tr>
			
			</thead>
		
			<tbody>
			
				<c:forEach items="${events}" var="e">
				
				<tr>
				
					<td><a href="/event_details/${e.id}">${e.name}</a></td>
					<td>${e.date}</td>
					<td>${e.location}</td>
					<td>${e.state}</td>
					<td>${e.user.firstName} ${e.user.lastName}</td>
					<td><a href="/edit_event/${e.id}">Edit</a> | <a href="/delete_event/${e.id}">Delete</a></td>
				</tr>
				
				</c:forEach>
	
			</tbody>
		
		</table>
	
	
	
	<hr>
	<h2>Create new event!</h2>
	
	<form:form action="/create_event" method="post" modelAttribute="event">
	
		<p>
			Name:
			<form:input path="name"/>
			<form:errors path="name"/>
		</p>
		
		<p>
			Date:
			<form:input type="date" path="date"/>
		</p>
		
		<p>
			Location:
			<form:input path="location"/>
			<form:errors path="location"/>
		</p>
		
		<p>
			State:
			<form:input path="state"/>
		</p>
		<button type="submit">Create Event</button>
	
	</form:form>
	
	
	
	
	
	
	
	
</body>
</html>