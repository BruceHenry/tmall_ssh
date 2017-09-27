package com.tmall.comparator;

import java.util.Comparator;

import com.tmall.pojo.Product;

/**
 * ProductPriceComparator 价格比较器
 * 把价格低的放前面
 * @author lds
 *
 */
public class ProductPriceComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return (int) (o1.getPromotePrice()-o2.getPromotePrice());
	}

}
