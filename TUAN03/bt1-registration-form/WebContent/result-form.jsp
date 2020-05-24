<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Form</title>
</head>
<body>
	<h1>User Information</h1>
	<p>First name: ${user.firstName}</p>
	<p>Last name: ${user.lastName}</p>
	<p>Email: ${user.email}</p>
	<p>Phone number: ${user.pnumber}</p>
	<p>Hobbies: ${user.showHobbies()}</p>
	<p>Address: ${user.address}</p>
	<p>Course: ${user.course}</p>
</body>
</html>