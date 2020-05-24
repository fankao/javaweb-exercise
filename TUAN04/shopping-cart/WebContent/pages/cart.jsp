<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="cart" scope="session" class="www.beans.CartBean"></jsp:useBean>

<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cart</title>
</head>
<style>
table {
	width: 100%;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 24px;
}

table, th, td {
	border: 1px solid black;
}

th {
	background-color: gray;
	color: white;
}
</style>

<body>
	<table>
		<tr>
			<th>Model description</th>
			<th>Quantity</th>
			<th>Unit Price</th>
			<th>Total</th>
		</tr>
		<c:if test="${cart.getLineItemCount() == 0}">
			<tr>
				<td colspan="4">Cart is empty</td>
			</tr>

		</c:if>
		<c:forEach var="item" items="${cart.cartItems }" varStatus="counter">
			<form>
			</form>
		</c:forEach>

		<tr>
			<td colspan="2"></td>
			<td></td>
			<td>Subtotal: $ 980000</td>
		</tr>
	</table>
	<br>
	<br>
	<a href="/shopping-cart/list">List of products</a>
</body>

</html>