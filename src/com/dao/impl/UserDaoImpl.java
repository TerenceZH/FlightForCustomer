package com.dao.impl;

import com.dao.UserDao;
import com.pojo.User;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{




	@Override
	public List<Long> getCountOfUser(User user) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByValueBean("select count(u.id) from User u where u.username=:username"
				+ " and u.password=:password", user);
	}

	

	@Override
	public void insertOne(User user) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(user);
	}



	@Override
	public User getOne(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(User.class, id);
	}



	@Override
	public List<Long> getCountOfUsername(User user) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByValueBean("select count(u.id) from User u where u.username=:username"
				, user);
	}



	@Override
	public User getOne(User user) {
		// TODO Auto-generated method stub
		return (User)getSession().createCriteria(User.class)
			.add(Restrictions.eq("username", user.getUsername()))
			.uniqueResult();
	}

	
	

	
}
