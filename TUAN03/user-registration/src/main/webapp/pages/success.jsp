<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<h1>Create user account successful</h1>
	<h3>Your information:</h3>
	<p>Name: ${user.firstName} ${user.lastName}</p>
	<p>Email: ${user.email}</p>
	<p>Date of birth: ${user.dateOfBirth}</p>
	<p>Gender: ${user.gender == true ? 'Female' : "Male" }</p>
</body>
</html>