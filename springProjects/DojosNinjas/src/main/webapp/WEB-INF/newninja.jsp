<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>New Ninja</title>
	
	<!-- BOOTSTRAP LINK -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
</head>
<body>


	<h1>Add a new Ninja!</h1>
	<a href="/">Go back</a>
	<hr>
	

	<form:form action="/ninjas/new" method="post" modelAttribute="ninjaObj">
		<p>
			Dojo: 
			<form:select path="dojo">
			
				<c:forEach items="${dojos}" var="dojo">
					<form:option value="${dojo.id}">${dojo.name}</form:option>
				</c:forEach>
		
			</form:select>
			<form:errors path="dojo"/>
		</p>
		
		<p>
			First Name: 
			<form:input type="text" path="firstName"/>
			<form:errors path="firstName"/>
		</p>
		
		<p>
			Last Name: 
			<form:input type="text" path="lastName"/>
			<form:errors path="lastName"/>
		</p>
		
		<p>
			Age: 
			<form:input type="text" path="age"/>
			<form:errors path="age"/>
		</p>
	
		<button class="btn btn-dark" type="submit">Create</button>
	</form:form>
	

</body>
</html>