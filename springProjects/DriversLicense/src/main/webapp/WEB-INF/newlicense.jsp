<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
        
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Create a New License</title>
	
	<!-- BOOTSTRAP LINK -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	
</head>
<body>
	
	<h1>New License</h1>
	
	<form:form action="/licenses/new" method="post" modelAttribute="licenseObj">
	
	<p>
		Person:
		<form:select path="person">
		
			<c:forEach items="${persons}" var="p">
			
				<form:option value="${p.id}">${p.firstName} ${p.lastName}</form:option>
			
			</c:forEach>
		
		</form:select>
	</p>
	
	<p>
		State:
		<form:input type="text" path="state" />	
		<form:errors path="state" />
	</p>
	
	<p>
		Expiration Date:
		<form:input type="date" path="expirationDate"/>	
		<form:errors path="expirationDate" />
	</p>
	
	<button class="btn btn-dark" type="submit">Create</button>
	</form:form>


</body>
</html>