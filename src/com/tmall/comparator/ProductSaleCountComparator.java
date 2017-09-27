package com.tmall.comparator;

import java.util.Comparator;
import com.tmall.pojo.Product;
/**
 * ProductSaleCountComparator 销量比较器
 * 把销量高的放在前面
 * @author lds
 *
 */

public class ProductSaleCountComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o2.getSaleCount()-o1.getSaleCount();
	}

}
