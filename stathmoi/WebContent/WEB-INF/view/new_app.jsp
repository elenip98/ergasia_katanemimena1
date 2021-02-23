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
<title>Create Application</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Create Application</h3>
<div class="outter">
	<form:form action="createapp" method="post"
		modelAttribute="createapp" >
		<div class="container">
			<label for="uname"><b>First Name</b></label>
			<form:input class="forminputcss" path="student.firstname" />
			<label for="uname"><b>Last Name</b></label>
			<form:input class="forminputcss" path="student.lastname" />
			<label for="uname"><b>Parent 1</b></label>
			<form:input class="forminputcss" path="student.parent1" />
			<label for="uname"><b>Parent 2</b></label>
			<form:input class="forminputcss" path="student.parent2" />
			<label for="uname"><b>Contact Information</b></label>
			<form:input class="forminputcss" path="student.contactinfo" />
			<label for="uname"><b>Age</b></label>
			<form:input class="forminputcss" path="student.age" />
			
			<label for="uname"><b>Finance</b></label>
			<form:input class="forminputcss" path="application.finace" />
			<label for="uname"><b>Social Info</b></label>
			<form:input class="forminputcss" path="application.socailinfo" />
			<label for="uname"><b>Extra Info</b></label>
			<form:input class="forminputcss" path="application.extrainfo" />

							<button class="General" type="submit" value="${stathmos.id}" name="ApplyButtonSec">Apply</button>

						</div>
					</form:form>
</div>


</body>
</html>