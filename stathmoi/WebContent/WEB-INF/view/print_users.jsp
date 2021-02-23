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
	
		<h3>Print User</h3>
		<div class="outter">

		

						<c:forEach var="tempUser" items="${myusers}">
								
								<div class="container">
								<div class="unipart">
								<table>
							
							
							
							<tr>
								<th >ID</th>
								<th>Username</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Email</th>
								<th>Role</th>
								<th>Enabled</th>
							</tr>
			
								
								<tr>
									<td>${tempUser.id}</td>
									<td>${tempUser.username}</td>
									<td>${tempUser.firstName}</td>
									<td>${tempUser.lastName}</td>
									<td>${tempUser.email}</td>
									<td>${tempUser.authority}</td>
									<td>${tempUser.enabled}</td>
									</tr>
									</table></div>
		</div>
	</c:forEach>

									
									</div>

</body>
</html>