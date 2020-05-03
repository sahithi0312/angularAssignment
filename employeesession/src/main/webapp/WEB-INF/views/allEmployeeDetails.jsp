<%@page import="com.capgemini.employeesession.beans.EmployeePrimary"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	List<EmployeePrimary> employeePrimary = (List<EmployeePrimary>)request.getAttribute("beanList");
	String errMsg = (String) request.getAttribute("zero");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
</head>
<body>

<div style="center">
	<a href="./home">home</a>
	
		<a href="./logout" style="float: right">Logout</a>
	</div>
<fieldset>
		<legend>Search Employee</legend>
		<form action="getEmployee" method="get">
			<label>Employee Id:</label> <input type="text" name="id" required><br>
			<input type="submit" value="Search">
		</form>
	</fieldset>
	<%
		if ((errMsg != null) && !errMsg.isEmpty()) {
	%>
	<h3 style="color: red;"><%=errMsg%></h3>
	<%
		}
	%>
	<%
		if (employeePrimary != null) {
	%>
	<div align="center">
	<table border="1" style="width: 60%">
		<tr style="background: navy; color: white;">
			<th>EmployeeId</th>
			<th>Name</th>
			<th>Password</th>
			<th>Age</th>
			<th>Salary</th>
		</tr>
		<%for(EmployeePrimary employeeInfoBean: employeePrimary){ %>
		<tr>
			<td><%=employeeInfoBean.getId()%></td>
			<td><%=employeeInfoBean.getName() %></td>
			<td><%=employeeInfoBean.getPassword()%></td>
			<td><%=employeeInfoBean.getAge()%></td>
			<td><%=employeeInfoBean.getSalary() %></td>
		</tr>
		<% }%>
	</table>
	</div>
	<%} %>
</body>
</html>