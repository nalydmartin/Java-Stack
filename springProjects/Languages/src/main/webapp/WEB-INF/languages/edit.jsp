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


	<a href="/languages">Dashboard</a>
	
	<form action="/languages/${lang.id}" method="post">
	
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	
	</form>
		

	<form:form action="/languages/${languages.id}" method="post" modelAttribute="languages">
	
		<form:label path="name">Name: </form:label>
		<form:errors path="name"/>
		<form:input type="text" path="name" placeholder="${languages.name}"/>
		
		<form:label path="creator">Creator: </form:label>
		<form:errors path="creator"/>
		<form:input type="text" path="creator" placeholder="${languages.creator}"/>
		
		<form:label path="currentVersion">Version: </form:label>
		<form:errors path="currentVersion"/>
		<form:input type="text" path="currentVersion" placeholder="${languages.currentVersion}"/>
		
		<input type="submit" value="Submit">
	</form:form>


</body>
</html>