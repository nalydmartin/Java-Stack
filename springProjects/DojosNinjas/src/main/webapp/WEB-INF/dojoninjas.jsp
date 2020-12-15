<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo and Ninjas</title>

<!-- BOOTSTRAP LINK -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
</head>
<body>

	<a href="/">Return Home</a>
	<h1><c:out value="${dojo.name}"/></h1>
	<hr>
	<a href="/ninjas/new">Add a new Ninja</a>
	

	<table class="table table-striped table-borderless">
		
		<thead class="thead-dark">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${dojo.ninjas}" var="d">
				<tr>
					<td>${d.firstName}</td>
					<td>${d.lastName}</td>
					<td>${d.age}</td>
				</tr>
			</c:forEach>
		
		</tbody>
	
	
	</table>



</body>
</html>