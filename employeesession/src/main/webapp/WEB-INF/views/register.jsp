<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Page</title>
</head>
<body>
	</div>
	<form action="register" method="post">
		<table>

			<tr>

				<td><label>Employee Id:</label></td>
				<td><input type="number" id="id" name="id" required><br>
				</td>
			</tr>
			<tr>
				<td><label>Employee Name:</label></td>
				<td><input type="text" id="name" name="name" required><br></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input name="password" type="password" required></input></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input name="age" type="number" required></input></td>
			</tr>
			<tr>
				<td>Salary:</td>
				<td><input name="salary" type="number" required></input></td>
			</tr>
			<td><input type="submit" value="submit"></td>
			</tr>

		</table>
	</form>
</body>
</html>