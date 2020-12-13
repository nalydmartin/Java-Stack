<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lookify Dashboard</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	
</head>
<body>

	<div class="container">
		
		<a href="/songs/new">Add New</a>
		
		<a href="/search/topTen">Top Songs</a>
		
		<form class="form-inline mb-2" action="/search" method="get">
		
			<input class="form-control" type="text" name="search"/>
			
			<button class="btn btn-dark ml-2" type="submit">Search Artists</button>
		</form>
	
	
	</div>

	<div>
		<table class="table table-striped table-borderless">
		
			<thead class="thead-dark">
				<tr>
					<th>Title</th>
					<th>Rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allSongs}" var="song">
				
				<tr> 
					<td><a href="/songs/${song.id}">${song.title}</a></td>
					<td>${song.rating}</td>
					<td><a href="/songs/${song.id}/delete">Delete</a></td>
					
				</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>




</body>
</html>