package www.beans;

/**
 * Xử lý thao tác liên quan đến giỏ hàng
 * @author NMC
 *
 */

import java.util.ArrayList;
import java.util.List;

public class CartBean {
	private List<CartItemBean> cartItems = new ArrayList<CartItemBean>();
	private double dblOrderTotal;

	/**
	 * tính số lượng sản phẩm trong giỏ hàng
	 * 
	 * @return
	 */
	public int getLineItemCount() {
		return cartItems.size();
	}

	/**
	 * xoá sản phẩm khỏi giỏ hàng
	 * 
	 * @param strItemIndex
	 */
	public void deleteCartItem(String strItemIndex) {
		int iItemIndex = 0;
		try {
			iItemIndex = Integer.parseInt(strItemIndex);
			cartItems.remove(iItemIndex - 1);
			calculateOrderTotal();
		} catch (NumberFormatException e) {
			System.out.println("Error while deleting cart item: " + e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Cập nhật giỏ hàng
	 * 
	 * @param strItemIndex
	 * @param strQuantity
	 */
	public void updateCartItem(String strItemIndex, String strQuantity) {
		double dblTotalCost = 0.0;
		double dblUnitCost = 0.0;
		int iItemIndex = 0;
		int iQuantity = 0;
		CartItemBean cartItemBean = null;

		try {
			iItemIndex = Integer.parseInt(strItemIndex);
			iQuantity = Integer.parseInt(strQuantity);

			if (iQuantity > 0) {
				cartItemBean = cartItems.get(iItemIndex - 1);
				dblUnitCost = cartItemBean.getDblUnitCost();
				dblTotalCost = dblUnitCost * iQuantity;
				cartItemBean.setiQuantity(iQuantity);
				cartItemBean.setDblTotalCost(dblTotalCost);
				calculateOrderTotal();
			}
		} catch (NumberFormatException e) {
			System.out.println("Error white updating cart: " + e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * Tính thành tiền
	 */
	private void calculateOrderTotal() {
		double total = 0.0;
		for (CartItemBean cartItemBean : cartItems) {
			total += cartItemBean.getDblTotalCost();
		}
		setDblOrderTotal(total);
	}

	/**
	 * Lấy thông tin item
	 * 
	 * @param iItemIndex
	 * @return
	 */
	public CartItemBean getCartItem(int iItemIndex) {
		CartItemBean cartItem = null;
		if (cartItems.size() > 0) {
			cartItem = cartItems.get(iItemIndex);
		}
		return cartItem;
	}

	public void addCartItem(String strModelNo, String strDesc, String strUnitCost, String strQuantity) {
		double dblTotalCost = 0.0;
		double dblUnitCost = 0.0;
		int iQuantity = 0;

		try {
			dblUnitCost = Double.parseDouble(strUnitCost);
			iQuantity = Integer.parseInt(strQuantity);
			CartItemBean cartItem = new CartItemBean();
			if (iQuantity > 0) {
				cartItem.setStrPartNumber(strModelNo);
				cartItem.setStrModelDescription(strDesc);
				cartItem.setiQuantity(iQuantity);
				cartItem.setDblUnitCost(dblUnitCost);

				dblTotalCost = dblUnitCost * iQuantity;
				cartItem.setDblTotalCost(dblTotalCost);
			}
		} catch (NumberFormatException e) {
			System.out.println("Error while parsing from String to primitive type: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void addCartItem(CartItemBean item) {
		cartItems.add(item);
	}

	public List<CartItemBean> getAlCartItems() {
		return cartItems;
	}

	public void setAlCartItems(List<CartItemBean> alCartItems) {
		this.cartItems = alCartItems;
	}

	public double getDblOrderTotal() {
		return dblOrderTotal;
	}

	public void setDblOrderTotal(double dblOrderTotal) {
		this.dblOrderTotal = dblOrderTotal;
	}

}
