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
<title>Create Class</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Create Class</h3>
<div class="outter">
	<form:form action="createclass" method="post"
		modelAttribute="createClass">
		<div class="container">
			<label for="uname"><b>Name</b></label>
			<form:input class="forminputcss" path="myClass.name" />
			
<label for="role"><b>Stathmos</b></label>
							<form:select class="forminputcss" path="stathmosID">
								<c:forEach items="${stathmoslist}" var="stathmos">
									<option value="${stathmos.id}">${stathmos.id}. ${stathmos.name}</option>
								</c:forEach>
							</form:select>
							
<label for="role"><b>Teacher</b></label>
							<form:select class="forminputcss" path="teacherID">
								<c:forEach items="${teacherlist}" var="teacher">
									<option value="${teacher.id}">${teacher.id}. ${teacher.firstName}
										${teacher.lastName}</option>
								</c:forEach>
							</form:select>
							
	

							<button class="General" type="submit">Create</button>

						</div>
					</form:form>
</div>


</body>
</html>
















