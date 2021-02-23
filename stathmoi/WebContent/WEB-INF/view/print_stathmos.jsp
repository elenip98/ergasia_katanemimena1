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
<title>Print Stathmo</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>ID: ${stathmos.id}</h3>
		<div class="outter">


							<p><b>Name:</b>			${stathmos.name}</p>
				<br/>
				<p><b>Capacity:</b>			${stathmos.capacity}</p>
				<br/>
				<p><b>Address:</b> 		${stathmos.address}</p>
				<br/>
				<p><b>Phone:</b> ${stathmos.phone}</p>
				<br/>
				<p><b>Information:</b>  ${stathmos.info}</p>
				<br/>
				<p><b>Enabled:</b> ${stathmos.enabled}</p>
				<br/>
				<p><b>Diefthidis:</b> ${stathmos.diefthidisID.firstName} ${stathmos.diefthidisID.lastName}</p>
				<br/>
				
							
</div>



</body>
</html>