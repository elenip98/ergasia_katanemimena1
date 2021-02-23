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
<title>Create Stathmo</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Create Stathmo</h3>
<div class="outter">
	<form:form action="createstathmos" method="post"
						modelAttribute="createstathmos">
						<div class="container">
							<label for="uname"><b>Name</b></label>
							<form:input class="forminputcss" path="stathmos.name" />

							<label for="email"><b>Capacity</b></label>
							<form:input path="stathmos.capacity" class="forminputcss" />
							
							<label for="fname"><b>Address</b></label>
							<form:input path="stathmos.address" />
							<label for="lname"><b>Phone</b></label>
							<form:input path="stathmos.phone" class="forminputcss" />
							<label for="email"><b>Info</b></label>
							<form:input path="stathmos.info" class="forminputcss" />


<label for="role"><b>Diefthidis</b></label>
							<form:select class="forminputcss" path="diefthidisID">
								<c:forEach items="${dieflist}" var="diefthidis">
									<option value="${diefthidis.id}">${diefthidis.id}. ${diefthidis.firstName}
										${diefthidis.lastName}</option>
								</c:forEach>
							</form:select>
							
							<form:select class="forminputcss" path="stathmos.enabled">
								<c:forEach items="${enabledList}" var="enabled">
									<option value="${enabled}"><c:if
											test="${enabled == 1}">
											<c:out value="Enabled" />
										</c:if><c:if test="${enabled == 0}">
											<c:out value="Disabled" />
										</c:if></option>
								</c:forEach>
							</form:select>
							
	

							<button class="General" type="submit">Create</button>

						</div>
					</form:form>
</div>


</body>
</html>
