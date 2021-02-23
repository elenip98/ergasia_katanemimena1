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
<title>Log In</title>
</head>
<body>

	<jsp:include page="include/header.jsp" />
<h3>Log In</h3>
		<div class="outter">
		<form name='loginForm' action="${loginUrl}" method="post">


		  <div class="container">
			<label for="uname"><b>Username</b></label> <input type="text"
								placeholder="Enter Username" name="username" required> <label
								for="psw"><b>Password</b></label> <input type="password"
								placeholder="Enter Password" name="password" required> <input
								type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
							<button class="General" type="submit">Login</button>
			<c:if test="${param.error != null}">
							<div id="error_div">Invalid username and password.</div>
						</c:if>
		  </div>
		</form>
		</div>
</body>
</html>