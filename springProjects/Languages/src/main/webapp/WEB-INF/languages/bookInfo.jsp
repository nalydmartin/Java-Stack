<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Language Information</title>
</head>
<body>

	<a href="/languages">Dashboard</a>

	<h3><c:out value="${languages.name}"/></h3>

	<h3><c:out value="${languages.creator}"/></h3>
	
	<h3><c:out value="${languages.currentVersion}"/></h3>
	
	
	<a href="/languages/${languages.id}/edit">Edit</a>
	
	<form action="/languages/${languages.id}" method="post">
	
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
		
	</form>
		
</body>
</html>