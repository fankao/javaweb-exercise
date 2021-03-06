<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Person page</title>
</head>
<body>
	<c:if test="${message!=null}">
		<p style="color: green; font-weight: bold;">${message}</p>
	</c:if>
	<form action="/person-crud-ogm/PersonServlet" method="post">
		<table>
			<tr>
				<td><label for="name">Name:</label></td>
				<td><input type="text" name="name" 
					required="required"></td>
			</tr>
			<tr>
				<td><label for="name">Country:</label></td>
				<td><input type="text" name="country"
					required="required"></td>
			</tr>
			<tr>
				<td><button type="submit">Add person</button></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Country</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach var="item" items="${persons}">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.country}</td>
				<td><a href="/person-crud-ogm/edit?id=${item.id}">Edit</a></td>
				<td><a href="/person-crud-ogm/delete?id=${item.id}"
					onclick="return confirm('Are you sure delete this person?')">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>