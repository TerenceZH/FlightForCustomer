package com.pojo;


public class Flight {
	private Long id;
	private String flightno;
	private String depart_city;
	private String arrival_city;
	private String depart_time;
	private String arrival_time;
	private int seat;
	private String seatinfo;
	private double price;
	private int tickets_left;
	
	
	public Flight(){
		
	}

	



	public String getSeatinfo() {
		return seatinfo;
	}





	public void setSeatinfo(String seatList) {
		this.seatinfo = seatList;
	}





	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	public String getFlightno() {
		return flightno;
	}

	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}

	public String getDepart_city() {
		return depart_city;
	}

	public void setDepart_city(String depart_city) {
		this.depart_city = depart_city;
	}

	public String getArrival_city() {
		return arrival_city;
	}

	public void setArrival_city(String arrival_city) {
		this.arrival_city = arrival_city;
	}

	public String getDepart_time() {
		return depart_time;
	}

	public void setDepart_time(String depart_time) {
		this.depart_time = depart_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getTickets_left() {
		return tickets_left;
	}

	public void setTickets_left(int tickets_left) {
		this.tickets_left = tickets_left;
	}

	
	
}
