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


				<p><b>Finance:</b>			${application.finace}</p>
				<br/>
				<p><b>Social Information:</b>			${application.socailinfo}</p>
				<br/>
				<p><b>Extra Info:</b> 		${application.extrainfo}</p>
				<br/>
				<p><b>Status:</b> ${application.status}</p>
				<br/>
				<p><b>Student:</b>  ${application.studentID.id} ${application.studentID.firstname} ${application.studentID.lastname}</p>
				<br/>
				<p><b>Dhmotis:</b> ${application.dhmotisID.id} ${application.dhmotisID.firstName} ${application.dhmotisID.lastName}</p>
				<br/>
				
							
</div>



</body>
</html>