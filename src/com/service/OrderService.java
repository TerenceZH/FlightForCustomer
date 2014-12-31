package com.service;

import java.util.List;

import com.common.ResultCode;
import com.pojo.Order;
import com.pojo.User;

public interface OrderService {
	public ResultCode addOrder(Order order);
	public ResultCode deleteOrder(List<Long> list);
	public List<Order> queryOrder(User user);
	public ResultCode payOrder(Order order);
	public Order getOne(Long id);
}
