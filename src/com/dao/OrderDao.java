package com.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.pojo.Order;
import com.pojo.User;

public interface OrderDao {
	
	public void insertOne(Order order);
	
	public Order getOne(Long id);
	
	
	public List<Order> queryList(User user);
	
	public void delAll(List<Order> list);
	
	public List<Order> findOrdersByIds(List<Long> id);
	
}
