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
<title>Print Applications</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Print Applications</h3>
		<div class="outter">

		<form:form action="printallapp" method="post"
						modelAttribute="rjapp">

						<c:forEach var="tempApp" items="${applications}">
								
								<div class="container">
								<div class="unipart">
								<table>
							
							
							
							<tr>
								<th >ID</th>
								<th>Finance</th>
								<th>Social Info</th>
								<th>Extra Info</th>
								<th>Status</th>
								<th>Student</th>
								<th>Dhmotis</th>
								<th></th>
								<th></th>
								<th>Status</th>
							</tr>
			
								
								<tr>
									<td>${tempApp.id}</td>
									<td>${tempApp.finace}</td>
									<td>${tempApp.socailinfo}</td>
									<td>${tempApp.extrainfo}</td>
									<td>${tempApp.status}</td>
									<td>${tempApp.studentID.firstname} ${tempApp.studentID.lastname}</td>
									<td>${tempApp.dhmotisID.firstName} ${tempApp.dhmotisID.firstName}</td>
									<td><button type="submit" name="AcceptButton" value="${tempApp.id}">Accept</button></td>
									<td><button type="submit" name="RejectButton" value="${tempApp.id}">Reject</button></td>
									<td><button class="greenButton"><c:out value="${tempApp.status}"/></button></td>
									</tr>
									</table></div>
		</div>
	</c:forEach>

									</form:form>
									</div>

</body>
</html>
