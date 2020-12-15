<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
	
	<!-- BOOTSTRAP LINK -->
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
		
</head>
<body>

	<h1>ALL DOJOS</h1>
	

	<table class="table table-striped table-borderless">
		
		<thead class="thead-dark">
			<tr>
				<th>Dojos</th>
				<th><a href="/dojos/new">Add a new Dojo</a></th>
				<th><a href="/ninjas/new">Add a new Ninja</a></th>
			</tr>
		</thead>
		
		<tbody>
		
			<c:forEach items="${dojos}" var="d">
			<tr>
				<td><a href="/dojos/${d.id}">${d.name}</a></td>
			
			</tr>
			</c:forEach>
		
		</tbody>
	
	
	</table>


</body>
</html>