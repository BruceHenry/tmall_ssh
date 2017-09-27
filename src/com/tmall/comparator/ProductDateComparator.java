package com.tmall.comparator;

import java.util.Comparator;
import com.tmall.pojo.Product;
/**
 * ProductDateComparator 新品比较器
 * 把创建日期晚的放前面
 * @author lds
 *
 */

public class ProductDateComparator implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		return o1.getCreateDate().compareTo(o2.getCreateDate());
	}

}
