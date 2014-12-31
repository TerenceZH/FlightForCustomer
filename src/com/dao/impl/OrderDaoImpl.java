package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.OrderDao;
import com.pojo.Order;
import com.pojo.User;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	@Override
	public void insertOne(Order order) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(order);
	}

	@Override
	public Order getOne(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Order.class, id);
	}

	@Override
	public List<Order> queryList(User user) {
		// TODO Auto-generated method stub
		return this.getSession().createCriteria(Order.class)
				.add(Restrictions.eq("user", user)).list();
	}

	@Override
	public void delAll(List<Order> list) {
		// TODO Auto-generated method stub
/*		System.out.println(list);*/
		getHibernateTemplate().deleteAll(list);
	}

	@Override
	public List<Order> findOrdersByIds(List<Long> id)
	{
		//离线Criteria
		DetachedCriteria dc = DetachedCriteria.forClass(Order.class);
		if(id.size()>1){
		for(int i = 0; i < id.size()-1;i++)
		{
			//这句话相当于sql语句中的where id=? or id= ? or id=? or.....）
			dc.add(Restrictions.or(Restrictions.eq("id", id.get(i)), Restrictions.eq("id", id.get(i+1))));
		}
		}
		else {
			dc.add(Restrictions.eq("id", id.get(0)));
		}
		return getHibernateTemplate().findByCriteria(dc);
	}

}
