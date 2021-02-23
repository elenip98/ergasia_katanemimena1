<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2>DHMOTIKOI BREFONIPIAKOI STATHMOI</h2>

	<ul>
		  <li class="myHeader"><a href="<c:url value='/home' />">Home</a></li>
		  <sec:authorize access="hasRole('ADMIN')">
		  <li class="myHeader"><div class="dropdown"><button class="dropbtn">
						Users 
					</button>
					<div class="dropdown-content">
						<a href="<c:url value='/admin/createuser' />">Create User</a> 
						<a href="<c:url value='/admin/finduser' />">Find User</a> 
						<a href="<c:url value='/admin/printusers' />">Print All Users</a>
					</div></div>
			</li>
		  <li class="myHeader"><div class="dropdown"><button class="dropbtn">
						Stathmoi 
					</button>
					<div class="dropdown-content">
						<a href="<c:url value='/admin/createstathmos' />">Create Stathmo</a> 
						<a href="<c:url value='/admin/findstathmoi' />">Find Stathmo</a> 
						<a href="<c:url value='/admin/printstathmoi' />">Print All Stathmoi</a>
					</div></div>
			</li><li class="myHeader"><div class="dropdown"><button class="dropbtn">
						Classes 
					</button>
					<div class="dropdown-content">
						<a href="<c:url value='/admin/createclass' />">Create Class</a> 
						<a href="<c:url value='/admin/findclasses' />">Find Class</a> 
						<a href="<c:url value='/admin/printclasses' />">Print All Classes</a>
					</div></div>
			</li>
			<li class="myHeader"><div class="dropdown"><button class="dropbtn">
						Students 
					</button>
					<div class="dropdown-content">
						<a href="<c:url value='/admin/createstudent' />">Create Student</a> 
						<a href="<c:url value='/admin/findstudent' />">Find Student</a> 
						<a href="<c:url value='/admin/printstudents' />">Print All Students</a>
					</div></div>
			</li>
			</sec:authorize>
			<sec:authorize access="hasRole('DIAX')">
		  <li class="myHeader"><a href="<c:url value='/diax/addstathmo' />">Add Stathmo</a></li>
		  <li class="myHeader"><a href="<c:url value='/diax/removestathmo' />">Remove Stathmo</a></li>
		  <li class="myHeader"><a href="<c:url value='/diax/findstathmo' />">Find Stathmo</a></li>
		  <li class="myHeader"><a href="<c:url value='/diax/stathmoilist' />">Print List Stathmon</a></li>
		  <li class="myHeader"><a href="<c:url value='/diax/createstathmos' />">Create Stathmo</a></li>
			
		</sec:authorize>
		<sec:authorize access="hasRole('DIEF')">
			<li class="myHeader"><a href="<c:url value='/dief/updatestathmo' />">Epikiropiisi Stoixion</a></li>
			<li class="myHeader"><div class="dropdown"><button class="dropbtn">
						Applications 
					</button>
					<div class="dropdown-content">
						<a href="<c:url value='/dief/printprossapp' />">Processing</a> 
						<a href="<c:url value='/dief/printaccapp' />">Accepted</a> 
						<a href="<c:url value='/dief/printrejapp' />">Rejected</a> 
						<a href="<c:url value='/dief/printallapp' />">All</a> 
					</div></div>
			</li>
		<li class="myHeader"><div class="dropdown"><button class="dropbtn">
						Classes 
					</button>
					<div class="dropdown-content">
						<a href="<c:url value='/dief/setclassteacher' />">Set Teachers</a> 
						<a href="<c:url value='/dief/setstudents' />">Set Students</a> 
					</div></div>
					
			</li>
		</sec:authorize>
		<sec:authorize access="hasRole('TEACHER')">
			
		  <li class="myHeader"><a href="<c:url value='/teacher/viewclasses' />">Classes</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('DIM')">
			<li class="myHeader"><a href="<c:url value='/dhmotis/getstathmoi' />">Stathmoi</a></li>
				<li class="myHeader"><div class="dropdown"><button class="dropbtn">
						Applications 
					</button>
					<div class="dropdown-content">
						<a href="<c:url value='/dhmotis/printprossapp' />">Processing</a> 
						<a href="<c:url value='/dhmotis/printaccapp' />">Accepted</a> 
						<a href="<c:url value='/dhmotis/printrejapp' />">Rejected</a> 
						<a href="<c:url value='/dhmotis/printallapp' />">All</a> 
					</div></div>
			</li>
			</sec:authorize>
			
		  <li><a href="<c:url value='/logout' />">Log Out</a></li>
		</ul>
	<br/>
	
	
	
	
</body>
</html>