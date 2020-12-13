<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add a New Song</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	
</head>
<body>

	<a href="/dashboard">Dashboard</a>
	
	<h1>Create a new song</h1>

	<form:form action="/songs/new" method="post" modelAttribute="SongObj">
	
		<p>
			Song Title:
			<form:input type="text" path="title"/>
			<form:errors path="title" />
		</p>
		<p>
			Song Artist:
			<form:input type="text" path="artist"/>
			<form:errors path="artist" />
		</p>
		
		<p>
			Song Rating:
			<form:select path="rating">
				<form:option value="1">1</form:option>
				<form:option value="2">2</form:option>
				<form:option value="3">3</form:option>
				<form:option value="4">4</form:option>
				<form:option value="5">5</form:option>
				<form:option value="6">6</form:option>
				<form:option value="7">7</form:option>
				<form:option value="8">8</form:option>
				<form:option value="9">9</form:option>
				<form:option value="10">10</form:option>
			</form:select>
			<form:errors path="rating"/>
		</p>
		
	
		<button class="btn btn-dark" type="submit">ADD SONG</button>
	</form:form>
	
	


</body>
</html>