package com.tmall.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.xwork.math.RandomUtils;
import org.apache.struts2.convention.annotation.Action;
import org.springframework.web.util.HtmlUtils;

import com.opensymphony.xwork2.ActionContext;
import com.tmall.comparator.ProductAllComparator;
import com.tmall.comparator.ProductDateComparator;
import com.tmall.comparator.ProductPriceComparator;
import com.tmall.comparator.ProductReviewComparator;
import com.tmall.comparator.ProductSaleCountComparator;
import com.tmall.pojo.OrderItem;
import com.tmall.pojo.Product;
import com.tmall.pojo.User;
import com.tmall.service.OrderService;
import com.tmall.service.ProductImageService;

public class ForeAction extends Action4Result {
	String msg;
	
	@Action("foredoreview")
	public String doreview(){
		t2p(order);
		t2p(product);
		
		order.setStatus(OrderService.finish);
		String content =review.getContent();
		content =HtmlUtils.htmlEscape(content);
		review.setContent(content);
		
		User user = (User) ActionContext.getContext().getSession().get("user");
		review.setContent(content);
		review.setProduct(product);
		review.setCreateDate(new Date());
		review.setUser(user);
		reviewService.saveReviewAndUpdateOrderStatus(review,order);
	      
	    showonly = true;
	    return "reviewPage";
	}
	
	@Action("forereview")
	public String review(){
		t2p(order);
		orderItemService.fill(order);
		product =order.getOrderItems().get(0).getProduct();
		reviews =reviewService.listByParent(product);
		productService.setSaleAndReviewNumber(product);
		return "review.jsp";
	}
	
	@Action("foredeleteOrder")
	public String deleteOrder(){
		t2p(order);
		order.setStatus(OrderService.delete);
		orderService.update(order);
		return "success.jsp";
	}
	
	@Action("foreorderConfirmed")
	public String orderConfirmed(){
		t2p(order);
		order.setStatus(OrderService.waitReview);
		order.setConfirmDate(new Date());
		orderService.update(order);
		return "orderConfirmed.jsp";
	}
	
	@Action("foreconfirmPay")
	public String confirmPay(){
		t2p(order);
		orderItemService.fill(order);
		return "confirmPay.jsp";
	}
	
	@Action("forebought")
	public String bought(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		orders =orderService.listByUserWithoutDelete(user);
		orderItemService.fill(orders);
		return "bought.jsp";
	}
	
	@Action("forepayed")
	public String payed(){
		t2p(order);
		order.setStatus(OrderService.waitDelivery);
		order.setPayDate(new Date());
		orderService.update(order);
		return "payed.jsp";
	}
	
	@Action("forealipay")
	public String forealipay(){
		return "alipay.jsp";
	}
	
	@Action("forecreateOrder")
	public String createOrder(){
		List<OrderItem> ois =(List<OrderItem>)ActionContext.getContext().getSession().get("orderItems");
		if(ois.isEmpty())
			return "login.jsp";
		User user =(User) ActionContext.getContext().getSession().get("user");
		String orderCode =new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())
				+RandomUtils.nextInt(10000);
		order.setOrderCode(orderCode);
		order.setCreateDate(new Date());
		order.setUser(user);
		order.setStatus(OrderService.waitPay);
		
		total = orderService.createOrder(order, ois);
		return "alipayPage";
	}
	
	@Action("foredeleteOrderItem")
	public String deleteOrderItem(){
		orderItemService.delete(orderItem);
		return "success.jsp";
	}
	
	@Action("forechangeOrderItem")
	public String changeOrderItem(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		List<OrderItem>ois =orderItemService.list("user",user,"order",null);
		for (OrderItem oi :ois){
			if(oi.getProduct().getId()==product.getId()){
				oi.setNumber(num);
				orderItemService.update(oi);
				break;
			}
		}
		return "success.jsp";
	}
	
	@Action("forecart")
	public String cart(){
		User user = (User) ActionContext.getContext().getSession().get("user");
		orderItems =orderItemService.list("user",user,"order",null);
		for(OrderItem orderItem : orderItems){
			productImageService.setFirstProdutImage(orderItem.getProduct());
		}
		return "cart.jsp";
	}
	
	@Action("foreaddCart")
	public String addCart() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		boolean found = false;

		List<OrderItem> ois = orderItemService.list("user", user, "order", null);
		for (OrderItem oi : ois) {
			if (oi.getProduct().getId() == product.getId()) {
				oi.setNumber(oi.getNumber() + num);
				orderItemService.update(oi);
				found = true;
				break;
			}
		}
		if (!found) {
			OrderItem oi = new OrderItem();
			oi.setUser(user);
			oi.setNumber(num);
			oi.setProduct(product);
			orderItemService.save(oi);
		}
		return "success.jsp";
	}

	@Action("forebuy")
	public String buy() {
		orderItems = new ArrayList<>();
		for (int oiid : oiids) {
			OrderItem oi = (OrderItem) orderItemService.get(oiid);
			total += oi.getProduct().getPromotePrice() * oi.getNumber();
			orderItems.add(oi);
			productImageService.setFirstProdutImage(oi.getProduct());
		}
		ActionContext.getContext().getSession().put("orderItems", orderItems);
		return "buy.jsp";
	}

	@Action("forebuyone")
	public String buyone() {
		User user = (User) ActionContext.getContext().getSession().get("user");
		boolean found = false;
		List<OrderItem> ois = orderItemService.list("user", user, "order", null);
		for (OrderItem oi : ois) {
			if (oi.getProduct().getId() == product.getId()) {
				oi.setNumber(oi.getNumber() + num);
				orderItemService.update(oi);
				found = true;
				oiid = oi.getId();
				break;
			}
		}

		if (!found) {
			OrderItem oi = new OrderItem();
			oi.setUser(user);
			oi.setNumber(num);
			oi.setProduct(product);
			orderItemService.save(oi);
			oiid = oi.getId();
		}
		return "buyPage";
	}

	@Action("foresearch")
	public String search() {
		products = productService.search(keyword, 0, 20);
		productService.setSaleAndReviewNumber(products);
		for (Product product : products) {
			productImageService.setFirstProdutImage(product);
		}
		return "searchResult.jsp";
	}

	@Action("forecategory")
	public String category() {
		t2p(category);
		productService.fill(category);
		productService.setSaleAndReviewNumber(category.getProducts());
		if (null != sort) {
			switch (sort) {
			case "review":
				Collections.sort(category.getProducts(), new ProductReviewComparator());
				break;
			case "date":
				Collections.sort(category.getProducts(), new ProductDateComparator());
				break;

			case "saleCount":
				Collections.sort(category.getProducts(), new ProductSaleCountComparator());
				break;

			case "price":
				Collections.sort(category.getProducts(), new ProductPriceComparator());
				break;

			case "all":
				Collections.sort(category.getProducts(), new ProductAllComparator());
				break;
			}
		}
		return "category.jsp";
	}

	@Action("foreloginAjax")
	public String loginAjax() {

		user.setName(HtmlUtils.htmlEscape(user.getName()));
		User user_session = userService.get(user.getName(), user.getPassword());

		if (null == user_session)
			return "fail.jsp";

		ActionContext.getContext().getSession().put("user", user_session);
		return "success.jsp";
	}

	@Action("forecheckLogin")
    public String checkLogin() {
        User u =(User) ActionContext.getContext().getSession().get("user");
        if(null==u)
            return "fail.jsp";
        else
            return "success.jsp";
    }

	@Action("foreproduct")
	public String product() {
		t2p(product);

		productImageService.setFirstProdutImage(product);
		productSingleImages = productImageService.list("product", product, "type", ProductImageService.type_single);
		productDetailImages = productImageService.list("product", product, "type", ProductImageService.type_detail);
		product.setProductSingleImages(productSingleImages);
		product.setProductDetailImages(productDetailImages);

		propertyValues = propertyValueService.listByParent(product);

		reviews = reviewService.listByParent(product);

		productService.setSaleAndReviewNumber(product);

		return "product.jsp";
	}

	@Action("forelogout")
	public String logout() {
		ActionContext.getContext().getSession().remove("user");
		return "homePage";
	}

	@Action("forelogin")
	public String login() {
		user.setName(HtmlUtils.htmlEscape(user.getName()));
		User user_session = userService.get(user.getName(), user.getPassword());
		if (null == user_session) {
			msg = "账号密码错误";
			return "login.jsp";
		}
		ActionContext.getContext().getSession().put("user", user_session);
		return "homePage";
	}

	@Action("forehome")
	public String home() {
		categorys = categoryService.list();
		productService.fill(categorys);
		productService.fillByRow(categorys);
		return "home.jsp";
	}

	@Action("foreregister")
	public String register() {
		user.setName(HtmlUtils.htmlEscape(user.getName()));
		boolean exist = userService.isExist(user.getName());

		if (exist) {
			msg = "用户名已经被使用,不能使用";
			return "register.jsp";
		}
		userService.save(user);
		return "registerSuccessPage";
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
