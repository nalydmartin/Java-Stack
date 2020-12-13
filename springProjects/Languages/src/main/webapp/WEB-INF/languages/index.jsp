<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
 <%@ page isErrorPage="true" %>  
 
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>     
 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>INDEX</title>
</head>
<body>


	<table>
		<thead>
		
			<th>Name</th>
			<th>Creator</th>
			<th>Version</th>
			<th>Actions</th>
			
		</thead>
		
		<tbody>
			<c:forEach items="${languages}" var="lang">
			<tr>
				<td><a href="/languages/${lang.id}">${lang.name}</a></td>
				<td><c:out value="${lang.creator}"/></td>		
				<td><c:out value="${lang.currentVersion}"/></td>
				<td><form action="/languages/${lang.id}" method="post">
	
					<input type="hidden" name="_method" value="delete">
					<input type="submit" value="Delete">
					</form> | 
					<a href="languages/${lang.id}/edit">Edit</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
		
	</table>

	 <form:form action="/languages" method="post" modelAttribute="Language">
	
		<form:label path="name">Name: </form:label>
		<form:errors path="name"/>
		<form:input type="text" path="name"/>
		
		<form:label path="creator">Creator: </form:label>
		<form:errors path="creator"/>
		<form:input type="text" path="creator"/>
		
		<form:label path="currentVersion">Version: </form:label>
		<form:errors path="currentVersion"/>
		<form:input type="text" path="currentVersion"/>
		
		<input type="submit" value="Submit">
		
	</form:form> 


</body>
</html>