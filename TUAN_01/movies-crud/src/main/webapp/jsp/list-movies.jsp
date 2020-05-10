<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- Latest compiled and minified CSS & JS -->
<link rel="stylesheet" media="screen"
	href="./resources/css/bootstrap.css">

<title>List of Movies</title>
</head>
<body>
	<div class="container">
		<header>
			<h1>List of Movies</h1>
		</header>
		<a type="button" class="btn btn-info"
			href="${pageContext.request.contextPath}/new"
			style="margin-bottom: 10px;">Add new movie</a>
		<section>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Year</th>
						<th>Title</th>
						<th>Directors</th>
						<th>Actor</th>
						<th>Running Time</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${movies}">
						<tr>
							<td>${item.id}</td>
							<td>${item.year}</td>
							<td>${item.title}</td>
							<td>${item.showListString(item.directors)}</td>
							<td>${item.showListString(item.actors)}</td>
							<td>${item.running_time_secs}</td>
							<td><a type="button" class="btn btn-warning"
								href="${pageContext.request.contextPath}/edit?id=${item.id}">Edit</a>
								<a type="button" class="btn btn-danger"
								href='${pageContext.request.contextPath}/delete?id=${item.id}'
								onclick="if(confirm('Are you sure delete this movie ?')) return">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</section>
	</div>
	
</body>
<script src="./resources/jquery-3.4.1.min.js"></script>
<script src="./resources/js/bootstrap.js"></script>
</html>