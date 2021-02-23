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
<title>Set Teachers-Classes</title>
</head>
<body>
	<jsp:include page="include/header.jsp" />
	
		<h3>Set Teachers-Classes</h3>
<div class="outter">
	<form:form action="setclassteacher" method="post"
						modelAttribute="setteacherclass">
						<div class="container">
							<label for="role"><b>Class</b></label>
							<form:select  path="myClass.id">
								<c:forEach items="${classlist}" var="myClass">
									<option value="${myClass.id}">${myClass.id} ${myClass.name}</option>
								</c:forEach>
							</form:select>
							<label for="role"><b>Teacher</b></label>
							<form:select path="teacher.id">
								<c:forEach items="${teacherlist}" var="teacher">
									<option value="${teacher.id}">${teacher.id}. ${teacher.firstName}
										${teacher.lastName}</option>
								</c:forEach>
							</form:select>
																		
							<button class="General" type="submit" >Set</button>

						</div>
					</form:form>
</div>


</body>
</html>