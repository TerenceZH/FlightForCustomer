package com.dao.impl;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.FlightDao;
import com.pojo.Account;
import com.pojo.Flight;

public class FlightDaoImpl extends HibernateDaoSupport implements FlightDao{

	@Override
	public List<Flight> querySome(String detime, String decity, String arcity) {
		// TODO Auto-generated method stub
		List<Flight> list =  this.getSession().createCriteria(Flight.class)
				.add(Restrictions.eq("depart_city", decity))
				.add(Restrictions.eq("arrival_city", arcity))
				.add(Restrictions.le("depart_time", timeString2(detime)))
				.add(Restrictions.ge("depart_time", timeString(detime)))
				.addOrder(Order.asc("depart_time"))
				.list();
		return list;
	}

	@Override
	public Flight getOne(Long id) {
		// TODO Auto-generated method stub
		return getHibernateTemplate().get(Flight.class, id);
	}

	@Override
	public Flight getOne(String flightno) {
		// TODO Auto-generated method stub
		return (Flight)getSession().createCriteria(Flight.class).add(Restrictions.eq("flightno", flightno)).uniqueResult();
	}

	
	private static String timeString(String s){
		return s+=" 00:00:00";
	}
	
	private static String timeString2(String s){
		return s+=" 23:59:59";
	}

}
