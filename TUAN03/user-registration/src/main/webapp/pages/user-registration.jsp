<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./resources/css/bootstrap.css">
<script src="./resources/jquery-3.4.1.min.js"></script>
<script src="./resources/js/bootstrap.js"></script>
<title>User Registration Form</title>
</head>
<body>
	<div class="container">
		<div class="col-xs-6">
			<form action="" method="POST" role="form">
				<legend>
					<h1>User Registration Form</h1>
				</legend>
				<div class="form-group row">
					<div class="col-sm-6">
						<input type="text" name="fname" id="input" class="form-control"
							value="${user.firstName}" placeholder="First name">
					</div>
					<div class="col-sm-6">
						<input type="text" name="lname" id="input" class="form-control"
							value="${user.lastName}" placeholder="Last name">
					</div>
				</div>
				<div class="form-group">
					<input type="text" name="email" value="${user.email}"
						class="form-control" id="" placeholder="Your email">
				</div>
				<div class="form-group">
					<input type="text" class="form-control" id=""
						placeholder="Re-enter email">
				</div>
				<div class="form-group">
					<input type="text" name="pass" value="${user.password}"
						class="form-control" id="" placeholder="New password">
				</div>
				<div class="form-group">
					<label for="input" class="control-label">Date of births</label>
					<div class="row">
						<div class="form-group">
							<div class="col-sm-4">
								<select name="date" id="input" class="form-control">
									<option value="-1" label="Date"></option>
									<c:forEach var="index" begin="1" end="31" step="1">
										<option value="${index}" label="${index}"></option>
									</c:forEach>
								</select>
							</div>
							<div class="col-sm-4">
								<select name="month" id="input" class="form-control">
									<option label="Month" value="-1"></option>
									<option label="Jan" value="Jan"></option>
									<option label="Feb" value="Feb"></option>
									<option label="Mar" value="Mar"></option>
									<option label="Apr" value="Apr"></option>
								</select>
							</div>
							<div class="col-sm-4">
								<select name="year" id="input" class="form-control">
									<option label="Year"></option>
									<option label="1990" value="1990"></option>
									<option label="1991" value="1991"></option>
									<option label="1992" value="1992"></option>
									<option label="1993" value="1993"></option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="radio">
					<label> <input type="radio" name="gender" id="input"
						value="true"> Female
					</label> <label> <input type="radio" name="gender" id="input"
						value="false"> Male
					</label>
				</div>
				<button type="submit" class="form-control btn btn-primary">Submit</button>
			</form>
		</div>

	</div>
</body>
</html>