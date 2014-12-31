package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.AccountDao;
import com.pojo.Account;

public class AccountDaoImpl extends HibernateDaoSupport implements AccountDao{

	@Override
	public void addOne(Account account) {
		// TODO Auto-generated method stub
		getHibernateTemplate().save(account);
	}

	@Override
	public Account getOne(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Account.class, id);
	}
	
	@Override
	public Account getOne(String account){
		return (Account)getSession().createCriteria(Account.class).add(Restrictions.eq("account", account)).uniqueResult();
	}

	@Override
	public List<Long> getCountOfAccount(Account account) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().findByValueBean("select count(a.id) from Account a"
				+ " where a.account=:account and a.password=:password", account);
	}
	

}
