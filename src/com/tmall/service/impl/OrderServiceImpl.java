package com.tmall.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tmall.pojo.Order;
import com.tmall.pojo.OrderItem;
import com.tmall.pojo.User;
import com.tmall.service.OrderItemService;
import com.tmall.service.OrderService;
@Service
public class OrderServiceImpl extends BaseServiceImpl implements OrderService {
	
	@Autowired 
	OrderItemService orderItemService;
	@Transactional(propagation=Propagation.REQUIRED,rollbackForClassName="Exception")	
	@Override
	public float createOrder(Order order, List<OrderItem> ois) {
		save(order);
		float total =0;
		for (OrderItem oi :ois){
			oi.setOrder(order);
			orderItemService.update(oi);
			total+= oi.getProduct().getPromotePrice()*oi.getNumber();
		}
		return total;
				
	}
	@Override
	public List<Order> listByUserWithoutDelete(User user) {
		DetachedCriteria dc  =DetachedCriteria.forClass(clazz);
		dc.add(Restrictions.eq("user", user));
		dc.add(Restrictions.ne("status", OrderService.delete));
		return findByCriteria(dc);
	}

}
