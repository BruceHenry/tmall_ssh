package com.tmall.action;

import java.util.List;

import com.tmall.pojo.Category;
import com.tmall.pojo.Product;
import com.tmall.pojo.ProductImage;
import com.tmall.pojo.Property;

public class Action4Pojo extends Action4Pagination {

	protected Category category;
	protected Property property;
	protected Product product;
	protected ProductImage productImage;

	protected List<Category> categorys;
	protected List<Property> propertys;
	protected List<Product> products;
	protected List<ProductImage> productSingleImages;
	protected List<ProductImage> productDetailImages;
	
	
	public List<ProductImage> getProductSingleImages() {
		return productSingleImages;
	}

	public void setProductSingleImages(List<ProductImage> productSingleImages) {
		this.productSingleImages = productSingleImages;
	}

	public List<ProductImage> getProductDetailImages() {
		return productDetailImages;
	}

	public void setProductDetailImages(List<ProductImage> productDetailImages) {
		this.productDetailImages = productDetailImages;
	}

	

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public List<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(List<Category> categorys) {
		this.categorys = categorys;
	}

	public List<Property> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<Property> propertys) {
		this.propertys = propertys;
	}

	public ProductImage getProductImage() {
		return productImage;
	}

	public void setProductImage(ProductImage productImage) {
		this.productImage = productImage;
	}
	
}
