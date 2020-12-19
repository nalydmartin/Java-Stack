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
    <title>Registration Page</title>
    <style>
	.container {
		padding-top: 4em;
		}
    </style>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-sm-3">
	    <h3>Register</h3>
	    
	   <p style="color:red;" > <form:errors path="user.*"/></p>
	    <form:form method="POST" action="/register" modelAttribute="user">
	   		<p>
	            <form:label path="firstName">First Name:</form:label><br>
	            <form:input type="firstName" path="firstName"/>
	        </p>
	        
	        <p>
	            <form:label path="lastName">Last Name:</form:label><br>
	            <form:input type="lastName" path="lastName"/>
	        </p>
	      
	        <p>
	            <form:label path="email">Email:</form:label><br>
	            <form:input type="email" path="email"/>
	        </p>
	        <p>
	            <form:label path="password">Password:</form:label><br>
	            <form:password path="password"/>
	        </p>
	        <p>
	            <form:label path="passwordConfirmation">Confirm Password:</form:label><br>
	            <form:password path="passwordConfirmation"/>
	        </p>

	        <button type="submit" class="btn btn-primary">Register</button>
	    </form:form>
	</div>
    <div class="col-sm-3">
	    <h3>Login</h3>
	    <p style="color:red;"><c:out value="${error}" /></p>
	    <form method="post" action="/login">
		
	        <p>
	            <label for="email">Email:</label><br>
	            <input type="text" id="email" name="email"/>
	        </p>
	        <p>
	            <label for="password">Password:</label><br>
	            <input type="password" id="password" name="password"/>
	        </p>

	        <button type="submit" class="btn btn-primary">Login</button>
	    </form>
    </div>
  </div>
</div>

</body>
</html>