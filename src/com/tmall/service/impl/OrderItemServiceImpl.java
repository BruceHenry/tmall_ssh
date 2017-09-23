package com.tmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tmall.pojo.Order;
import com.tmall.pojo.OrderItem;
import com.tmall.service.OrderItemService;
import com.tmall.service.ProductImageService;
@Service
public class OrderItemServiceImpl extends BaseServiceImpl implements OrderItemService {
	
	@Autowired
	ProductImageService productImageService;
	
	@Override
	public void fill(List<Order> orders) {
		for(Order order:orders)
			fill(order);

	}

	@Override
	public void fill(Order order) {
		List<OrderItem> orderItems =this.listByParent(order);
		order.setOrderItems(orderItems);
		
		float total =0;
		int totalNumber=0;
		for(OrderItem oi : orderItems){
			total+=oi.getNumber()*oi.getProduct().getPromotePrice();
			totalNumber+=oi.getNumber();
			productImageService.setFirstProdutImage(oi.getProduct());
		}
		order.setTotal(total);
		order.setOrderItems(orderItems);
		order.setTotalNumber(totalNumber);

	}

}
