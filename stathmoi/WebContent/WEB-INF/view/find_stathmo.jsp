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
<title>Find Stathmo</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Find Stathmo</h3>
<div class="outter">
	<form:form action="findstathmo" method="post"
						modelAttribute="findstathmo">
						<div class="container">
							<label for="uname"><b>Name</b></label>
							<form:input class="forminputcss" path="name" />

							<button class="General" type="submit">Search</button>

						</div>
					</form:form>
</div>


</body>
</html>