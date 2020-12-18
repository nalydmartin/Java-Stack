<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Event Details</title>
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	
</head>
<body>
	
	<a href="/home">Go Home</a>
	
	<h1><c:out value="${event.name}"/></h1>

	<p>Host: <c:out value="${event.user.userName}"/></p>
	
	<p>Date: <c:out value="${event.date}"/></p>
	
	<p>Location: <c:out value="${event.location}, ${event.state}"/></p>
	
	<hr>
	
	<table class="table table-striped table-borderless">
		
		<thead class="thead-dark">
			<tr>
				<th>Comments</th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${message}" var="m" >
			
				<tr>
					<td>${m.user.userName} says:<br> ${m.comment}</td>
					
				</tr>
			
			</c:forEach>
			
		</tbody>
		
	</table>

	 <hr>
	 
	

	<form action="/comment/${event.id}" method="post" >
		<input type="hidden" value="${event.id}"/>
		
		<p>Post a comment:
			<input name="comment" type="text"/>
		</p>
		<p><c:out value="${error}"/></p>
		
		<button class="btn btn-dark" type="submit">Comment</button>
	
	
	</form>

</body>
</html>