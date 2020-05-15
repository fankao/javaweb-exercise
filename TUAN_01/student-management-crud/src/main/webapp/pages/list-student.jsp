<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="./resources/css/bootstrap.css" />
<title>List of students</title>
</head>
<body style="padding: 10px; box-sizing: content-box;">
	<div class="container">
		<header>
			<div class="row" style="border: 2px solid;">
				<img class="col-xs-4 col-sm-4 col-md-4 col-lg-4"
					src="./resources/Logo_IUH.png" alt="Logo IUH" width="60"
					height="100" />
				<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
					<h3
						style="font-family: 'Times New Roman', Times, serif; font-weight: bold;">
						CHƯƠNG TRÌNH QUẢN LÝ THÔNG TIN SINH VIÊN</h3>
				</div>
			</div>
		</header>
		<div class="row"
			style="border: 2px solid; border-top: none; height: 500px;">
			<div class="col-xs-3" style="border-right: 2px solid; height: 100%;">
				<a href="/student-management-crud/new">
					<h3>Thêm mới sinh viên</h3>
				</a> 
				<a href="/student-management-crud/list">
					<h3>Danh sách sinh viên</h3>
				</a>
			</div>

			<div class="col-xs-9" style="padding: 15px; height: 100%;">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>Mã SV</th>
							<th>Họ và tên</th>
							<th>Giới tính</th>
							<th>Số điện thoại</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${students}">
							<tr>
								<td width="50px">${item.maSV}</td>
								<td>${item.hoVaTen}</td>
								<td>${item.gioiTinh == true?'Nam' : 'Nữ'}</td>
								<td>${item.soDienThoai}</td>
								<td>
									<a href="/student-management-crud/edit?maSV=${item.maSV}" class="btn btn-warning">Edit</a>
									<a href="/student-management-crud/delete?maSV=${item.maSV}" class="btn btn-danger" onclick="return confirm('Bạn có muốn xoá sinh viên này?')">Delete</a>
								</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
		</div>
		<footer class="row" style="border: 2px solid; border-top: none;">
			<h3
				style="text-align: center; font-family: 'Times New Roman', Times, serif;">
				Họ tên - Mã số SV thực hiện chương trình</h3>
		</footer>
	</div>
</body>
<script src="./resources/jquery-3.4.1.min.js"></script>
<script src="./resources/js/bootstrap.js"></script>
</html>