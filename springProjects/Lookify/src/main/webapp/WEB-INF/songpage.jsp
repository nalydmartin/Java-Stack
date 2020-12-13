<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	
</head>
<body>

	<a href="/dashboard">Dashboard</a>
	<table class="table table-striped table-borderless">
		<thead class="thead-dark">
			<tr>
				<th>Title</th>
				<th>Artist</th>
				<th>Rating (1-10)</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><c:out value="${song.title}"/></td>
				<td><c:out value="${song.artist}"/></td>
				<td><c:out value="${song.rating}"/></td>
			</tr>
		</tbody>
		
	</table>
	<a class="btn btn-danger" href="/songs/${song.id}/delete">Delete</a>
	
</body>
</html>