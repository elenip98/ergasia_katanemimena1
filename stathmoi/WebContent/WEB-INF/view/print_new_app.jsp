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
<title>Print Application</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>ID: ${application.id}</h3>
		<div class="outter">
				<br/>
				<p><b>First Name:</b>			${student.firstname}</p>
				<br/>
				<p><b>Last Name:</b>			${student.lastname}</p>
				<br/>
				<p><b>Parent 1:</b> 		${student.parent1}</p>
				<br/>
				<p><b>Parent 2:</b> ${student.parent2}</p>
				<br/>
				<p><b>Contact Information:</b>  ${student.contactinfo}</p>
				<br/>
				<p><b>Age:</b> ${student.age}</p>
				<br/>
				<p><b>Finance:</b>			${application.finace}</p>
				<br/>
				<p><b>Social Information:</b>			${application.socailinfo}</p>
				<br/>
				<p><b>Extra Info:</b> 		${application.extrainfo}</p>
				<br/>
				<p><b>Status:</b> ${application.status}</p>
				
</div>

</body>
</html>