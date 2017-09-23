package com.tmall.service;

import java.util.List;

import com.tmall.pojo.Order;

public interface OrderItemService extends BaseService {
	public void fill(List<Order> orders);
	public void fill(Order order);
}
