package com.tmall.action;

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;

import com.tmall.pojo.Product;
import com.tmall.util.Page;

public class ProductAction extends Action4Result {

	@Action("admin_product_list")
	public String list() {
		if (page == null)
			page = new Page();
		int total = productService.total(category);
		page.setTotal(total);
		page.setParam("&category.id=" + category.getId());
		products = productService.list(page, category);
		for(Product product:products){
			productImageService.setFirstProdutImage(product);
		}
		t2p(category);
		return "listProduct";
	}

	@Action("admin_product_add")
	public String add() {
		product.setCreateDate(new Date());
		productService.save(product);
		return "listProductPage";
	}

	@Action("admin_product_delete")
	public String delete() {
		t2p(product);
		productService.delete(product);
		return "listProductPage";
	}

	@Action("admin_product_edit")
	public String edit() {
		t2p(product);
		return "editProduct";
	}

	@Action("admin_product_update")
	public String update() {
		Product productFromDB = (Product) productService.get(product.getId());
		product.setCreateDate(productFromDB.getCreateDate());
		productService.update(product);
		return "listProductPage";
	}

}
