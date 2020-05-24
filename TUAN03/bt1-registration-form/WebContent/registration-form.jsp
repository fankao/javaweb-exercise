<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="./css/bootstrap.css">
<title></title>
</head>

<body>
	<div class="container" style="padding-top: 20px;">
		<form action="UserServlet" method="POST" class="form-horizontal"
			role="form">
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">First name</label>
				<div class="col-sm-4">
					<input type="text" name="fName" id="input" class="form-control"
						>
				</div>
				<div class="col-sm-6">
					<span>(max 30 characters a-z and A - Z)</span>
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">Last name</label>
				<div class="col-sm-4">
					<input type="text" name="lName" id="input" class="form-control"
						>
				</div>
				<div class="col-sm-6">
					<span>(max 30 characters a-z and A - Z)</span>
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">Date of
					births</label>
				<div class="col-sm-8">
					<div class="form-group">
						<div class="col-sm-2">
							<select name="date" id="input" class="form-control">
								<option value="" label="Date"></option>
							</select>
						</div>
						<div class="col-sm-2">
							<select name="month" id="input" class="form-control">
								<option label="Month"></option>
							</select>
						</div>
						<div class="col-sm-2">
							<select name="year" id="input" class="form-control">
								<option label="Year"></option>
							</select>
						</div>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">Email</label>
				<div class="col-sm-4">
					<input type="email" name="email" id="input" class="form-control"
						value="">
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">Mobile
					number</label>
				<div class="col-sm-4">
					<input type="tel" name="pnumber" id="input" class="form-control">
				</div>
				<div class="col-sm-6">
					<span>(10 digits number)</span>
				</div>
			</div>
			<div class="form-group">
				<label for="textarea" class="col-sm-2 control-label">Address</label>
				<div class="col-sm-4">
					<textarea name="address" id="textarea" class="form-control"
						rows="3"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">City</label>
				<div class="col-sm-4">
					<input type="text" name="city" id="input" class="form-control"
						>
				</div>
				<div class="col-sm-6">
					<span>(max 30 characters a-z and A - Z)</span>
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">Pin code</label>
				<div class="col-sm-4">
					<input type="text" name="pin" id="input" class="form-control"
						>
				</div>
				<div class="col-sm-6">
					<span>(10 digits number)</span>
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">State</label>
				<div class="col-sm-4">
					<input type="text" name="state" id="input" class="form-control"
						>
				</div>
				<div class="col-sm-6">
					<span>(max 30 characters a-z and A - Z)</span>
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">Country</label>
				<div class="col-sm-4">
					<input type="text" name="state" id="input" class="form-control"
						>
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-xs-2 control-label">Hobbies</label>
				<div class="col-xs-10">
					<div class="checkbox">
						<label> <input type="checkbox" name="hobbies" value="Drawing"> Drawing
						</label> <label> <input type="checkbox" name="hobbies" value="Singing"> Singing
						</label> <label> <input type="checkbox" name="hobbies" value="Dancing"> Dancing
						</label> <label> <input type="checkbox" value="Sketching">
							Sketching
						</label> <label> <input type="checkbox" name="hobbies" value="Other"> Other
						</label> <label> <input type="checkbox" name="hobbies" value=""> <input
							type="text" name="other">
						</label>
					</div>
				</div>
			</div>

			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">Qualification</label>
				<div class="col-sm-10">

					<table class="table">
						<thead>
							<tr>
								<th>Sl.No.</th>
								<th>Examination</th>
								<th>Board</th>
								<th>Percentage</th>
								<th>Year of passing</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>Class X</td>
								<td><input type="text" name="" id=""></td>
								<td><input type="text" name="" id=""></td>
								<td><input type="text" name="" id=""></td>
							</tr>
							<tr>
								<td>2</td>
								<td>Class XII</td>
								<td><input type="text" name="" id=""></td>
								<td><input type="text" name="" id=""></td>
								<td><input type="text" name="" id=""></td>
							</tr>
							<tr>
								<td>3</td>
								<td>Graduration</td>
								<td><input type="text" name="" id=""></td>
								<td><input type="text" name="" id=""></td>
								<td><input type="text" name="" id=""></td>
							</tr>
							<tr>
								<td>4</td>
								<td>Masters</td>
								<td><input type="text" name="" id=""></td>
								<td><input type="text" name="" id=""></td>
								<td><input type="text" name="" id=""></td>
							</tr>
							<tr>
								<td colspan="2"></td>
								<td><span>(10 char max)</span></td>
								<td><span>(up to 2 decimal)</span></td>
								<td></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="form-group">
				<label for="input" class="col-sm-2 control-label">Course
					apply for</label>
				<div class="col-sm-10">
					<div class="radio">
						<label> <input type="radio" name="course" id="input"
							value="BCA"> BCA
						</label> <label> <input type="radio" name="course" id="input"
							value="B.com"> B.com
						</label> <label> <input type="radio" name="course" id="input"
							value="B.Sc"> B.Sc
						</label> <label> <input type="radio" name="course" id="input"
							value="B.A"> B.A
						</label>
					</div>

				</div>
			</div>




			<div class="col-sm-10 col-sm-offset-2">
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form>
	</div>
</body>
<script src="./jquery-3.4.1.min.js"></script>
<script src="./js/bootstrap.js"></script>

</html>