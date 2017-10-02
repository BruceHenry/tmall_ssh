package com.tmall.service;

import com.tmall.pojo.Order;
import com.tmall.pojo.Review;

public interface ReviewService extends BaseService {
	void saveReviewAndUpdateOrderStatus(Review review, Order order);
}
