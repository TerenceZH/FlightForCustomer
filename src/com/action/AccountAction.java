package com.action;

import com.common.ResultCode;
import com.pojo.Account;
import com.pojo.Flight;
import com.pojo.Order;
import com.service.AccountService;
import com.service.FlightService;
import com.service.OrderService;

public class AccountAction {
	private Account account;
	private AccountService accountService;
	private String message;
	private Order order;
	private Long orderno;
	private OrderService orderService;

	
	
	
	
	public Long getOrderno() {
		return orderno;
	}
	public void setOrderno(Long orderno) {
		this.orderno = orderno;
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	public String login(){
		ResultCode result = accountService.loginAccount(account);
		System.out.println("login()");
		if(result==ResultCode.SUCCESS){
//			System.out.println(orderno);
			order = orderService.getOne(orderno);
			account = accountService.getAccount(account.getAccount());
			ResultCode result2 = accountService.payAccount(account,order.getFlight().getPrice());
			ResultCode result3 = orderService.payOrder(order);
			if(result2==ResultCode.SUCCESS && result3==ResultCode.SUCCESS){
				return "AccountloginSuccess";
			}else if(result2==ResultCode.ACCOUNT_REST_OUT){
				message = "Óà¶î²»×ã";
				return "error";
			}else {
				message = "Î´Öª´íÎó";
				return "error";
			}
		}else if(result==ResultCode.ACCOUNT_NOTEXIST){
			message = "ÕÊ»§ÃûÃÜÂë´íÎó";
			return "error";
		}else {
			message = "Î´Öª´íÎó";
			return "error";
		}
	}
	
	
	public String  forwardLogin(){
		System.out.println("forwardLogin()");
		return "AccountforwardLoginSuccess";
	}
	

}
