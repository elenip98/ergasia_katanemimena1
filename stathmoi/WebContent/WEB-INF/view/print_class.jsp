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
<title>Print Class</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>ID: ${myClass.id}</h3>
		<div class="outter">


							<p><b>Name:</b>			${myClass.name}</p>
				<br/>
				<p><b>Teacher:</b>			${myClass.teacherID.firstName} ${myClass.teacherID.lastName}</p>
				<br/>
				<p><b>Stathmos:</b> 		${myClass.stathmosID.name}</p>
				<br/>

							
</div>



</body>
</html>