package com.tmall.comparator;

import java.util.Comparator;

import com.tmall.pojo.Product;
/**
 * ProductReviewComparator 人气比较器
 * 把评论数量多的放在前面
 * @author lds
 *
 */

public class ProductReviewComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o2.getReviewCount() -o1.getReviewCount();
	}

}
