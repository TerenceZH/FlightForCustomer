package com.action;

import java.util.ArrayList;
import java.util.List;

import com.pojo.Flight;
import com.service.FlightService;

public class FlightAction {
	private Flight flight;
	private FlightService flightService;
	private String message ;
	private List<Flight> list;
	
	
	
	
	
	public List<Flight> getList() {
		return list;
	}
	public void setList(List<Flight> list) {
		this.list = list;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public FlightService getFlightService() {
		return flightService;
	}
	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String queryFlight(){
//		System.out.println(flight.getDepart_city()+" "+flight.getArrival_city()+" "+flight.getDepart_time());
		list = flightService.queryFlight(flight.getDepart_time(),flight.getDepart_city(),flight.getArrival_city());
//		System.out.println(list);
		return "FlightqueryFlightSuccess";
	}
	
	public String queryFlight2(){
		list = new ArrayList<Flight>();
		return "FlightqueryFlight2Success";
	}

}
