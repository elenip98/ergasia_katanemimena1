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
<title>Print User</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>ID: ${myuser.id}</h3>
		<div class="outter">


							<p><b>Username:</b>			${myuser.username}</p>
				<br/>
				<p><b>Fist Name:</b>			${myuser.firstName}</p>
				<br/>
				<p><b>Last Name:</b> 		${myuser.lastName}</p>
				<br/>
				<p><b>Email:</b> ${myuser.email}</p>
				<br/>
				<p><b>Role:</b>  ${myuser.authority}</p>
				<br/>
				<p><b>Enabled:</b> ${myuser.enabled}</p>
				<br/>
							
</div>



</body>
</html>