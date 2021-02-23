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
<title>Print Students</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Print Students</h3>
		<div class="outter">

		

						<c:forEach var="tempStudent" items="${students}">
								
								<div class="container">
								<div class="unipart">
								<table>
							
							
							
							<tr>
								<th >ID</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Parent 1</th>
								<th>Parent 2</th>
								<th>Contact Info</th>
								<th>Age</th>
								<th>Class</th>
							</tr>
			
								
								<tr>
									<td>${tempStudent.id}</td>
									<td>${tempStudent.firstname}</td>
									<td>${tempStudent.lastname}</td>
									<td>${tempStudent.parent1}</td>
									<td>${tempStudent.parent2}</td>
									<td>${tempStudent.contactinfo}</td>
									<td>${tempStudent.age}</td>
									<td>${tempStudent.classID.name}</td>
									</tr>
									</table></div>
		</div>
	</c:forEach>

									
									</div>

</body>
</html>