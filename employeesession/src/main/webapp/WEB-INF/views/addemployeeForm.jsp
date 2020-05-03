<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
</head>
<body>
<div style="centre">
<a href="./home">Home</a>
<a href="./logout" style="float: right;">Logout</a>
</div>
	<form action="addEmployee" method="post">
		<table>
			<tr>
				<td>Id:</td>
				<td><input name="id" type="number"></input></td>
			</tr>
			<tr>
				<td>Name:</td>
				<td><input name="name" type="text"></input></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input name="password" type="password"></input></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input name="age" type="number"></input></td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td><input name="salary" type="number"></input></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></input></td>
			</tr>
		</table>
	</form>

</body>
</html>