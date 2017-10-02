package com.tmall.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.tmall.pojo.Order;
import com.tmall.pojo.Review;
import com.tmall.service.OrderService;
import com.tmall.service.ReviewService;
@Service
public class ReviewServiceImpl extends BaseServiceImpl implements ReviewService {
	
	@Autowired OrderService orderService;
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")
	@Override
	public void saveReviewAndUpdateOrderStatus(Review review, Order order) {
		orderService.update(order);
		save(review);
		
	}
	
}
