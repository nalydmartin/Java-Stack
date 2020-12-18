<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Event Details</title>
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
	
</head>
<body>

	<h1><c:out value="${event.name}"/> </h1>
	<a href="/home">Return Home</a>
	<hr>
	
	<form:form action="/edit_event/${event.id}" method="post" modelAttribute="event">
	
		<p>Name:
			<form:input type="text" path="name" value="${event.name}"/>
			<form:errors path="name" />
		</p>
	
		<p>Date:
			<form:input type="date" path="date" value="${event.date}"/>
			<form:errors path="date" />
		</p>
		
		<p>Location:
			<form:input type="text" path="location" value="${event.location}"/>
			<form:errors path="location" />
			<form:select path = "state" value="${event.state}">
			<form:option value ="AL">Alabama</form:option> <form:option value ="AK">Alaska</form:option> <form:option value ="AZ">Arizona</form:option> <form:option value ="AR">Arkansas</form:option>
			<form:option value ="CA">California</form:option> <form:option value ="CO">Colorado</form:option> <form:option value ="CT">Connecticut</form:option> <form:option value ="DE">Delaware</form:option> 
			<form:option value ="FL">Florida</form:option> <form:option value ="GA">Georgia</form:option> <form:option value ="HI">Hawaii</form:option> <form:option value ="ID">Idaho</form:option> 
			<form:option value ="IL">Illinois</form:option> <form:option value ="IN">Indiana</form:option> <form:option value ="IA">Iowa</form:option> <form:option value ="KS">Kansas</form:option> <form:option value ="KY">Kentucky</form:option>
			<form:option value ="LA">Louisana</form:option> <form:option value ="ME">Maine</form:option> <form:option value ="MD">Maryland</form:option> <form:option value ="MA">Massachusetts</form:option> <form:option value ="MI">Michigan</form:option> 
			<form:option value ="MN">Minnesota</form:option> <form:option value ="MS">Mississippi</form:option> <form:option value ="MO">Missouri</form:option> <form:option value ="MT">Montana</form:option> <form:option value ="NE">Nebraska</form:option>
			<form:option value ="NV">Nevada</form:option> <form:option value ="NH">New Hampshire</form:option> <form:option value ="NJ">New Jersey</form:option> <form:option value ="NM">New Mexico</form:option> <form:option value ="NY">New York</form:option> 
			<form:option value ="NC">North Carolina</form:option> <form:option value ="ND">North Dakota</form:option> <form:option value ="OH">Ohio</form:option> <form:option value ="OK">Oklahoma</form:option> <form:option value ="OR">Oregon</form:option>
			<form:option value ="PA">Pennsylvania</form:option> <form:option value ="RI">Rhode Island</form:option> <form:option value ="SC">South Carolina</form:option> <form:option value ="SD">South Dakota</form:option> <form:option value ="TN">Tennessee</form:option>
			<form:option value ="TX">Texas</form:option> <form:option value ="UT">Utah</form:option> <form:option value ="VT">Vermont</form:option> <form:option value ="VA">Virginia</form:option> <form:option value ="WA">Washington</form:option> <form:option value ="WV">West Virginia</form:option> 
			<form:option value ="WI">Wisconsin</form:option> <form:option value ="WY">Wyoming</form:option>
			</form:select>
		</p>
		
		
		<button class="btn btn-dark" type="submit">Create Event</button>
	
	
	
	</form:form>
	
	
</body>
</html>