<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<%@page session="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="<c:url value="/rsc/mycss.css"/>">
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<jsp:include page="include/header.jsp" />

	<div class="outter">
	
		<h3>Welcome</h3>
		<p>This is the home page. Use the main menu above to navigate yourself to your next action.<p>
	
	</div>

</body>
</html>