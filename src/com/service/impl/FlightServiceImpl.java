package com.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.common.ResultCode;
import com.dao.FlightDao;
import com.exception.DaoException;
import com.pojo.Flight;
import com.service.FlightService;

public class FlightServiceImpl implements FlightService{
	
	private FlightDao flightDao;
	
	

	

	public FlightDao getFlightDao() {
		return flightDao;
	}



	public void setFlightDao(FlightDao flightDao) {
		this.flightDao = flightDao;
	}



	@Override
	public List<Flight> queryFlight(String detime, String decity, String arcity) {
		// TODO Auto-generated method stub
		return flightDao.querySome(detime, decity, arcity);
	}



	@Override
	public ResultCode modFlight(Flight flight) {
		// TODO Auto-generated method stub
		Flight oldFlight = flightDao.getOne(flight.getId());
		BeanUtils.copyProperties(flight, oldFlight);
		return ResultCode.SUCCESS;
	}



	@Override
	public Flight getFlight(String flightno) {
		// TODO Auto-generated method stub
		return flightDao.getOne(flightno);
	}



}
