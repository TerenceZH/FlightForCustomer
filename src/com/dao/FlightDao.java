package com.dao;

import java.util.List;

import com.pojo.Flight;

public interface FlightDao {
	
	public List<Flight> querySome(String detime,String decity,String arcity);
	public Flight getOne(Long id);
	public Flight getOne(String flightno);
}
