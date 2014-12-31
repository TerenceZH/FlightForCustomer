package com.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.common.ResultCode;
import com.dao.FlightDao;
import com.dao.OrderDao;
import com.pojo.Order;
import com.pojo.User;
import com.service.OrderService;

public class OrderServiceImpl implements OrderService{
	
	private OrderDao orderDao;


	

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public ResultCode addOrder(Order order) {
		// TODO Auto-generated method stub	
		orderDao.insertOne(order);
		return ResultCode.SUCCESS;
	}

	@Override
	public ResultCode deleteOrder(List<Long> list) {
		// TODO Auto-generated method stub
		orderDao.delAll(orderDao.findOrdersByIds(list));
		return ResultCode.SUCCESS;
	}

	@Override
	public List<Order> queryOrder(User user) {
		// TODO Auto-generated method stub
		return orderDao.queryList( user);
	}

	@Override
	public ResultCode payOrder(Order order) {
		// TODO Auto-generated method stub
		order.setIssent(1);
		Order oldOrder =  orderDao.getOne(order.getId());
		BeanUtils.copyProperties(order, oldOrder);
		return ResultCode.SUCCESS;
	}

	@Override
	public Order getOne(Long id) {
		// TODO Auto-generated method stub
		return orderDao.getOne(id);
	}

}
