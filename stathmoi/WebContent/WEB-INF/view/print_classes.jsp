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
<title>Print Classes</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Print Classes</h3>
		<div class="outter">

		

						<c:forEach var="tempClasses" items="${classes}">
								
								<div class="container">
								<div class="unipart">
								<table>
							
							
							
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Teacher</th>
								<th>Stathmos</th>
							</tr>
			
								
								<tr>
									<td>${tempClasses.id}</td>
									<td>${tempClasses.name}</td>
									<td>${tempClasses.teacherID.firstName} ${tempClasses.teacherID.lastName}</td>
									<td>${tempClasses.stathmosID.name}</td>
									</tr>
									</table></div>
		</div>
	</c:forEach>

									
									</div>

</body>
</html>