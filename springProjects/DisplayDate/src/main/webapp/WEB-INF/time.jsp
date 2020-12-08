<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html>
	
<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Display Time</title>
		<script src="/js/time.js"></script>
		<link rel="stylesheet" href="/css/time.css">
	</head>
	
	<body>
	
		
		<h1>Display Time: </h1>
		
		<h2><c:out value="${time}"/></h2>
		
		
	</body>
	
</html>