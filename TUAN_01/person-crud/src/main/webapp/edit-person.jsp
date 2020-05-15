<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit person</title>
</head>
<body>
	<form action="/person-crud-ogm/PersonServlet" method="post">
		<input type="hidden" name="id" value="${person.id}">
		<table>
			<tr>
				<td><label for="name">Name:</label></td>
				<td><input type="text" name="name" value="${person.name}"
					required="required"></td>
			</tr>
			<tr>
				<td><label for="name">Country:</label></td>
				<td><input type="text" name="country" value="${person.country}"
					required="required"></td>
			</tr>
			<tr>
				<td><button type="submit">Edit person</button></td>
			</tr>
		</table>
	</form>
</body>
</html>