package com.tmall.comparator;

import java.util.Comparator;

import com.tmall.pojo.Product;

/**
 * ProductAllComparator 综合比较器
 * 把销量*评论 高的放在前面
 * @author lds
 *
 */
public class ProductAllComparator implements Comparator<Product> {
	
	@Override
	public int compare(Product o1, Product o2) {
		return o2.getReviewCount() * o2.getSaleCount() - o1.getReviewCount() * o1.getSaleCount();

	}

}
