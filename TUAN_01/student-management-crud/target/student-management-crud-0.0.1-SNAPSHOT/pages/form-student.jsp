<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<title>List of students</title>
</head>

<body style="padding: 10px; box-sizing: content-box;">
	<div class="container">
		<header>
			<div class="row" style="border: 2px solid;">
				<img class="col-xs-4 col-sm-4 col-md-4 col-lg-4"
					src="../resources/Logo_IUH.png" alt="Logo IUH" width="60"
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
				<a href="">
					<h3>Thêm mới sinh viên</h3>
				</a> <a href="">
					<h3>Danh sách sinh viên</h3>
				</a>
			</div>

			<div class="col-xs-9" style="padding: 15px; height: 100%;">
				<form action="" method="POST" class="form-horizontal" role="form">
					<div class="form-group">
						<label class="control-label col-sm-2" for="maSV">Mã sinh
							viên:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="maSV" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="hoTen">Họ và
							tên:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="hoTen" />
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="hoTen">Giới
							tính:</label>
						<div class="col-sm-10">
							<div class="radio">
								<label> <input type="radio" name="gioTinh" value="">
									Nam
								</label> <label> <input type="radio" name="gioTinh" value="">
									Nữ
								</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="sdt">Số điện
							thoại:</label>
						<div class="col-sm-10">
							<input type="tel" class="form-control" name="sdt" />
						</div>
					</div>
					<div class="form-group">
						<label for="textarea" class="col-sm-2 control-label">Địa
							chỉ:</label>
						<div class="col-sm-10">
							<textarea name="diaChi" class="form-control" rows="3"
								required="required"></textarea>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-10 col-sm-offset-2">
							<button type="submit" class="btn btn-primary">Submit</button>
						</div>
					</div>

				</form>
			</div>
		</div>
		<footer class="row" style="border: 2px solid; border-top: none;">
			<h3
				style="text-align: center; font-family: 'Times New Roman', Times, serif;">
				Họ tên - Mã số SV thực hiện chương trình</h3>
		</footer>
	</div>
</body>
<script src="../resources/jquery-3.4.1.min.js"></script>
<script src="../resources/js/bootstrap.js"></script>

</html>