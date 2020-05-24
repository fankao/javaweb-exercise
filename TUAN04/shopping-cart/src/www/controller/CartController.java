package www.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import www.beans.CartBean;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");

		switch (action) {
		case "addToCart":
			addToCart(request);
			break;
		case "update":
			updateCart(request);
			break;
		case "delete":
			deleteCart(request);
			break;
		}

		response.sendRedirect("/shopping-cart/pages/cart.jsp");

	}

	protected void deleteCart(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String strItemIndex = request.getParameter("itemIndex");

		CartBean cartBean = null;
		Object objCart = session.getAttribute("cart");

		if (objCart != null) {
			cartBean = (CartBean) objCart;
		} else {
			cartBean = new CartBean();
		}
		cartBean.deleteCartItem(strItemIndex);
	}

	protected void updateCart(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String strItemIndex = request.getParameter("itemIndex");

		String strQuantity = request.getParameter("quantity");

		CartBean cartBean = null;
		Object objCart = session.getAttribute("cart");

		if (objCart != null) {
			cartBean = (CartBean) objCart;
		} else {
			cartBean = new CartBean();
		}
		cartBean.updateCartItem(strItemIndex, strQuantity);

	}

	protected void addToCart(HttpServletRequest request) {
		HttpSession session = request.getSession();

		String strModelNo = request.getParameter("modelNo");
		String strDesc = request.getParameter("description");
		String strPrice = request.getParameter("price");
		String strQuantity = request.getParameter("quantity");

		CartBean cartBean = null;
		Object objCart = session.getAttribute("cart");

		if (objCart != null) {
			cartBean = (CartBean) objCart;
		} else {
			cartBean = new CartBean();
		}

		cartBean.addCartItem(strModelNo, strDesc, strPrice, strQuantity);
	}

}
