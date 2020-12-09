<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>The Secret Code</title>
	
	<style>
		p {
			color:orange;
			text-shadow: 2px 2px 10px black;
		}
		
		h2 {
			color:white;
			text-shadow: 2px 2px 10px black;
		}
		
		body {
			background-image: linear-gradient(45deg, red, blue, red);
		}
		
		input {
			background-color: cyan;
			color: lime;
		}
		
		::placeholder {
			color: yellow;
		}
	</style>
</head>

<body>

	<p><c:out value="${error}"></c:out></p>
	
	<h2>What is the code?</h2>
	
	<form action="/check_pass" method="POST">
	
		<input type="text" name="password" placeholder="Enter password">
		<input type="submit" value="Submit">
		
	</form>

</body>


</html>