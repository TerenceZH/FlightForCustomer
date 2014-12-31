package com.action;

import java.util.List;
import java.util.Map;

import com.common.Func;
import com.common.ResultCode;
import com.opensymphony.xwork2.ActionContext;
import com.pojo.Flight;
import com.pojo.Order;
import com.pojo.User;
import com.service.FlightService;
import com.service.OrderService;
import com.service.UserService;

public class OrderAction {
	
	private List<Order> list;
	private OrderService orderService;
	private Order order;
	private Map<String,Object> session;
	private String message;
	private User user;
	private FlightService flightService;
	private List<Long> id;
	private Flight flight;
	private String flightno;
	private UserService userService;
	private long orderno;
	
	public long getOrderno() {
		return orderno;
	}
	public void setOrderno(long orderno) {
		this.orderno = orderno;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getFlightno() {
		return flightno;
	}
	public void setFlightno(String flightno) {
		this.flightno = flightno;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	public List<Long> getId() {
		return id;
	}
	public void setId(List<Long> id) {
		this.id = id;
	}
	public FlightService getFlightService() {
		return flightService;
	}
	public void setFlightService(FlightService flightService) {
		this.flightService = flightService;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	
	
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	public String queryOrder(){
		session = ActionContext.getContext().getSession();
		if(session.get("user")==null){
			message = "ÇëÏÈµÇÂ½£¡";
			return "error";
		}
		user = userService.getUser((User)session.get("user"));
		list = orderService.queryOrder(user);
		System.out.println("Arrival_city : " + list.get(0).getFlight().getArrival_city());
		return "OrderqueryOrderSuccess";
	}
	
	public String delOrders(){
	//	System.out.println(id);
		session = ActionContext.getContext().getSession();
		if(session.get("user")==null){
			message = "ÇëÏÈµÇÂ½£¡";
			return "error";
		}
		for(Long i:id){
			Flight f = orderService.getOne(i).getFlight();
			int seat = f.getTickets_left();
			f.setTickets_left(seat+1);
			f.setSeatinfo(Func.addSeatInfo(f.getSeatinfo(), orderService.getOne(i).getSeatno()+""));
			flightService.modFlight(f);
		}
		ResultCode resultCode = orderService.deleteOrder(id);
		if(resultCode==ResultCode.SUCCESS){
			user = userService.getUser((User)session.get("user"));
			list = orderService.queryOrder(user);
			System.out.println(list.size());
			return "OrderdelOrderSuccess";
		}else {
			message = "Î´Öª´íÎó";
			return "error";
		}
		
	}
	
	public String addOrder(){
		session = ActionContext.getContext().getSession();
		if(session.get("user")==null){
			message = "ÇëÏÈµÇÂ½£¡";
			return "error";
		}
		flight = flightService.getFlight(flightno);
		int seat = flight.getTickets_left();
		if(seat<=0){
			message = "ÒÑÊÛóÀ";
			return "error";
		}else {
			int seatNo = Integer.parseInt(flight.getSeatinfo().split(",")[0]);
//			System.out.println(Func.delSeatInfo(flight.getSeatinfo(), String.valueOf(seatNo)));
			flight.setSeatinfo(Func.delSeatInfo(flight.getSeatinfo(), String.valueOf(seatNo)));
			flight.setTickets_left(flight.getTickets_left()-1);
			order = new Order();
			order.setSeatno(seatNo);
			order.setFlight(flight);
			order.setTime(Func.getTimeString());
			order.setIssent(0);
			session = ActionContext.getContext().getSession();
			user = userService.getUser((User)session.get("user"));
			order.setUser(user);
			ResultCode result1 = flightService.modFlight(flight);
			ResultCode result2 = orderService.addOrder(order);
			if(result1==ResultCode.SUCCESS && result2==ResultCode.SUCCESS){
				orderno = order.getId();
//				return "AccountforwardLoginSuccess?orderno="+order.getId();
				return "AccountforwardLoginSuccess";
		//		return "OrderforwardAccount?orderno=";
			} else {
				message =  "Î´Öª´íÎó";
				return "error";
			}
		}
	}

}
