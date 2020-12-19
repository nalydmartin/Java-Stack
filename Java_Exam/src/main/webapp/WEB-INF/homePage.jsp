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
	<h3>Welcome, <c:out value="${user.username}" /></h3>
	<a href="/logout">Logout</a>
	
	<a href="/new">Add a new show</a>
	<hr>
	
	
	<table class="table table-striped table-bordered">
		
			<thead class="thead-dark">
				
				<tr>
					<th>Name</th>
					<th>Network</th>
					<th>Rating</th>
				</tr>
			
			</thead>
		
			<tbody>
			
				<c:forEach items="${shows}" var="show">
				
				<tr>
				
					<td><a href="/show/${show.id}">${show.name}</a></td>
					<td>${show.network}</td>
					<td>${show.rating}</td>
				</tr>
				
				</c:forEach>
	
			</tbody>
		
		</table>
	
	
	
	
	
	
	
	
	
	
</body>
</html>