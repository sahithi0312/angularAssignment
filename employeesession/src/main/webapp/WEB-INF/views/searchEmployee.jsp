<%@page import="com.capgemini.employeesession.beans.EmployeePrimary"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	EmployeePrimary employeePrimary = (EmployeePrimary) request.getAttribute("employeeInfo");
	String errMsg = (String) request.getAttribute("errMsg");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<h4>
			<a href="./home">Home</a> <br> <a href="./logout">Logout</a>
		</h4>
		<legend>Search Employee</legend>
		<form action="getEmployee" method="get">
			<label>Employee ID:</label> <input type="number" name="id" required><br>
			<br> <input type="submit" name="Search">
		</form>
		<%
			if (errMsg != null && !errMsg.isEmpty()) {
		%>
		<h3 style="color: red;"><%=errMsg%></h3>
		<%
			}
		%>
		<%
			if (employeePrimary != null) {
		%>
		<div align="center"></div>
		<table border="1" style="width: 60%">
			<tr style="background: navy; color: white;">
				<th>EmployeeId</th>
				<th>Name</th>
				<th>Password</th>
				<th>Age</th>
				<th>Salary</th>
			</tr>
			<tr>
				<td><%=employeePrimary.getId()%></td>
				<td><%=employeePrimary.getName()%></td>
				<td><%=employeePrimary.getPassword()%></td>
				<td><%=employeePrimary.getAge()%></td>
				<td><%=employeePrimary.getSalary()%></td>
			</tr>
		</table>
		</div>
		<%
			}
		%>
	</fieldset>
</body>
</html>