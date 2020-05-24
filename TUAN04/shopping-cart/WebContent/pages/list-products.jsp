<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>List of Products</title>
</head>
<style>
.flex-container {
	display: flex;
	flex-wrap: wrap;
	justify-content: center;
}

.flex-container>div {
	border: 1px solid;
	width: 300px;
	padding: 5px;
	margin: 10px;
	text-align: center;
	line-height: 10px;
}
</style>

<body>
	<div style="margin-left: 106px;">
		<a href="cart.html">View cart</a>
	</div>
	<div class="flex-container">
		<form action="/shopping-cart/CartController" method="POST">
			<c:forEach var="item" items="${lstProduct}">
				<div>
					<h4>${item.model}</h4>
					<img src="/shopping-cart${item.imgUrl}" width="50%" />
					<p>Price: ${item.price }</p>
					<input type="text" size="10" value="1" name="quantity" /> <input
						type="hidden" name="modelNo" value="${item.id}" /> <input
						type="hidden" name="description" value="${item.description}" /> <input
						type="hidden" name="price" value="${item.price}" /> <br> <br>

					<button type="submit" name="addToCart">Add to Cart</button>
				</div>
			</c:forEach>
		</form>
	</div>
</body>

</html>