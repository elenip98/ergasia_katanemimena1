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
<title>Create User</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Create User</h3>
<div class="outter">
	<form:form action="createuser" method="post"
		modelAttribute="createUser" >
		<div class="container">
			<label for="uname"><b>Username</b></label>
			<form:input path="username" />
			<label for="psw"><b>Password</b></label>
			<form:password path="password" />


			<label for="fname"><b>First Name</b></label>
			<form:input path="firstName" />
			<label for="lname"><b>Last Name</b></label>
			<form:input path="lastName"  />
			<label for="email"><b>Email</b></label>
			<form:input path="email"  />


			<label for="role"><b>Role</b></label>
			<form:select  path="authority">
				<c:forEach items="${roleList}" var="role">
					<option value="${role}">
						<c:if test="${role == 'ROLE_ADMIN'}">
							<c:out value="Admin" />
						</c:if>
						<c:if test="${role == 'ROLE_DIAX'}">
							<c:out value="Diaxiristis" />
						</c:if>
						<c:if test="${role == 'ROLE_DIEF'}">
							<c:out value="Diefthidis" />
						</c:if>
						<c:if test="${role == 'ROLE_TEACHER'}">
							<c:out value="Teacher" />
						</c:if>
						<c:if test="${role == 'ROLE_DIM'}">
							<c:out value="Dhmotis" />
						</c:if></option>
				</c:forEach>


			</form:select>

			<label for="role"><b>Enabled</b></label>
			<form:select  path="enabled">
				<c:forEach items="${enabledList}" var="enabled">
					<option value="${enabled}"><c:if test="${enabled == 1}">
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