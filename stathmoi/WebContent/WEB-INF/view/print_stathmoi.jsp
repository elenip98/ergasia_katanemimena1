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
<title>Print Stathmoi</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Print Stathmoi</h3>
		<div class="outter">

		

						<c:forEach var="tempStathmoi" items="${stathmoi}">
								
								<div class="container">
								<div class="unipart">
								<table>
							
							
							
							<tr>
								<th>ID</th>
								<th>Name</th>
								<th>Capacity</th>
								<th>Address</th>
								<th>Phone</th>
								<th>Info</th>
								<th>Enabled</th>
								<th>Diefthidis</th>
							</tr>
			
								
								<tr>
									<td>${tempStathmoi.id}</td>
									<td>${tempStathmoi.name}</td>
									<td>${tempStathmoi.capacity}</td>
									<td>${tempStathmoi.address}</td>
									<td>${tempStathmoi.phone}</td>
									<td>${tempStathmoi.info}</td>
									<td>${tempStathmoi.enabled}</td>
									<td>${tempStathmoi.diefthidisID.firstName} ${tempStathmoi.diefthidisID.lastName} </td>
									</tr>
									</table></div>
		</div>
	</c:forEach>

									
									</div>

</body>
</html>