<%@page import="com.capgemini.employeesession.beans.EmployeePrimary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	EmployeePrimary loggedInEmpInfo = (EmployeePrimary) session.getAttribute("loggedInEmpInfo");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="width: 50%;" align="center">
		<h1 style="color: navy;">
			Welcome<%=loggedInEmpInfo.getName()%>!
		</h1>
	</div>
	<a href="./getEmployeeForm">Search Employee</a>
	<br>
	<a href="./addEmployeeForm">Add Employee</a>
	<br>
	<a href="./updateEmployeeForm">Update Employee</a>
	<br>
	<a href="./deleteEmployeeForm">Delete Employee</a>
	<br>
	<a href="./seeAllEmployees">See All Employees</a>
	<br>
	<br>
	<a href="./Logout">Logout</a>
</body>
</html>