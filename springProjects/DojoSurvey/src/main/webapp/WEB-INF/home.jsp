<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
	
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Info Form</title>
	
	<style>
	</style>
</head>

<body>
	
	<form action="/submit" method="POST">
		
		<label for="name">Your Name: </label>
		<input type="text" name="name" placeholder="Enter Name...">
		<br>
		
		<label for="dojo">Dojo Location: </label>
		<select name="dojo">
			
			<option value="San Jose">San Jose</option>
			<option value="Irvine">Irvine</option>
			<option value="Burbank">Burbank</option>
			<option value="Seattle">Seattle</option>
			
		</select>
		<br>
		<label for="lang">Favorite Language: </label>
		<select name="lang">
			
			<option value="Python">Python</option>
			<option value="JAVA">JAVA</option>
			<option value="JavaScript">JavaScript</option>
			<option value="HTML">HTML</option>
			<option value="CSS">CSS</option>
			<option value="React">React</option>
			
		</select>
		<br>
		<label>Comment (optional): </label>
		<textarea name="comm" rows="6" cols="40"></textarea>
		
		<br>
		<input type="submit" value="Submit">
		
	</form>

</body>


</html>