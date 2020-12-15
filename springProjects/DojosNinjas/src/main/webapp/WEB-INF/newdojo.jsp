<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Dojo</title>
	
	<!-- BOOTSTRAP LINK -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
</head>
<body>

	<h1>Add a new Dojo!</h1>
	<a href="/">Go back</a>
	<hr>
	

	<form:form action="/dojos/new" method="post" modelAttribute="dojoObj">
		<p>
			Name: 
			<form:input type="text" path="name"/>
			<form:errors path="name"/>
		</p>
	
		<button class="btn btn-dark" type="submit">Create</button>
	</form:form>

</body>
</html>