package com.service;

import java.util.List;

import com.common.ResultCode;
import com.pojo.Flight;

public interface FlightService {
	public List<Flight> queryFlight(String detime,String decity,String arcity);
	public ResultCode modFlight(Flight flight);
	public Flight getFlight(String flightno);
}
