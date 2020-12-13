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

	<h2>Top Ten Songs: </h2>
	
	<div>
		<table class="table table-striped table-borderless">
			<tbody>
				<c:forEach items="${topSongs}" var="song">
				
				<tr>
					<td>${song.rating} - <a href="/songs/${song.id}">${song.title}</a> - ${song.artist}</td>	
				</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>