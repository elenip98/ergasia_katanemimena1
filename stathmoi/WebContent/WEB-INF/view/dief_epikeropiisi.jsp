<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/rsc/mycss.css"/>">
<meta charset="ISO-8859-1">
<title>Epikiropiisi Stathmou</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Epikiropiisi Stathmou</h3>
<div class="outter">
	<form:form action="updatestathmo" method="post"
						modelAttribute="updatestathmo">
						<div class="container">
							<label for="uname"><b>Name</b></label>
							<form:input  path="name" value="${stathmos.name}"/>

							<label for="email"><b>Capacity</b></label>
							<form:input path="capacity" value="${stathmos.capacity}"/>
							
							<label for="fname"><b>Address</b></label>
							<form:input path="address" value="${stathmos.address}"/>
							<label for="lname"><b>Phone</b></label>
							<form:input path="phone"  value="${stathmos.phone}"/>
							<label for="email"><b>Info</b></label>
							<form:input path="info"  value="${stathmos.info}"/>												
	
							<p>Warning: This action will delete all last year's applications.</p>
							<button class="General" type="submit" value="${stathmos.id}" name="UpdateStathmoButton">Update</button>

						</div>
					</form:form>
</div>


</body>
</html>