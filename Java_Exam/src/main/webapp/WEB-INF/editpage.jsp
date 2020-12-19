<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Page</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	
</head>
<body>

	<a href="/home">Go Home</a>

	<hr>

	<form:form action="" method="post" modelAttribute="show">
	
		<p>
			Title:
			<form:input type="text" path="name" value="${show.name}"/>
			<form:errors path="name"/>
		</p>
		<p>
			Network:
			<form:input type="text" path="network" value="${show.network}"/>
			<form:errors path="network"/>
		</p>
		<p>
			Rating:
			<form:select path="rating">
				<form:option value="0"></form:option>
				<form:option value="1">1</form:option>
				<form:option value="2">2</form:option>
				<form:option value="3">3</form:option>
				<form:option value="4">4</form:option>
				<form:option value="5">5</form:option>
			</form:select>
			<form:errors path="rating"/>
		</p>
	
		<button class="btn btn-dark" type="submit">Create Show</button>
	</form:form>
	



</body>
</html>