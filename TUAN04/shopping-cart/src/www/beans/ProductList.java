package www.beans;

import java.util.ArrayList;
import java.util.List;

import www.model.Product;

public class ProductList {
	private static final List<Product> ds = new ArrayList<Product>();
	static {
		initData();
	}

	public static List<Product> queryDatas() {
		return ds;
	}

	private static void initData() {
		Product sp = new Product();
		sp.setId("PRO01");
		sp.setModel("Iphone 11");
		sp.setDescription("Điện thoại Iphone 11");
		sp.setQuantity(10);
		sp.setPrice(3000);
		sp.setImgUrl("/images/iphone11.jpg");
		ds.add(sp);

		sp = new Product();
		sp.setId("PRO02");
		sp.setModel("Xiaomi 8");
		sp.setDescription("Điện thoại Xiaomi 8");
		sp.setQuantity(20);
		sp.setPrice(1500);
		sp.setImgUrl("/images/xiaomi8.jpg");
		ds.add(sp);

		sp = new Product();
		sp.setId("PRO03");
		sp.setModel("Oppo 12");
		sp.setDescription("Điện thoại Oppo 12");
		sp.setQuantity(15);
		sp.setPrice(900);
		sp.setImgUrl("/images/oppo12.jpg");
		ds.add(sp);

	}
}
