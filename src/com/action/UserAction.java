package com.action;

import java.util.Map;

import com.common.ResultCode;
import com.opensymphony.xwork2.ActionContext;
import com.pojo.User;
import com.service.UserService;

public class UserAction {
	private User user;
	private UserService userService;
	private String message;
	private String validatecode;
	private Map<String, Object> session;
	
	public String getValidatecode() {
		return validatecode;
	}
	public void setValidatecode(String validatecode) {
		this.validatecode = validatecode;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public  String forwardLogout(){
		return "UserforwardLogoutSuccess";
	}
	public String forwardLogin(){
		return "UserforwardLoginSuccess";
	}
	
	public String forwardRegister(){
		System.out.println("ddddd");
		return "UserforwardRegisterSuccess";
	}
	
	public String forwardInfo(){
		session = ActionContext.getContext().getSession();
		if(session.get("user")==null){
			message = "请先登陆！";
			return "error";
		}
		user = userService.getUser((User)session.get("user"));
		
		return "UserforwardInfoSuccess";
	}
	
	
	public String login(){
		session = ActionContext.getContext().getSession();
		String code = (String) session.get("validateCode");
		if (!validatecode.equalsIgnoreCase(code)){
			message = "验证码错误";
			return "error";
		}
		ResultCode result = userService.login(user);
		switch (result) {
		case SUCCESS:
			session.put("user", user);
			return "UserloginSuccess";
		case USERNAME_NOTEXIST:
			message = "用户名不存在或者用户名密码不匹配";
			break;
		default:
			message = "未知错误";
			break;
		}
		return "error";
	}
	
	public String logout(){
		session = ActionContext.getContext().getSession();
		session.put("user", null);
		return "UserlogoutSuccess";
	}
	
	public String register(){
		session = ActionContext.getContext().getSession();
		String code = (String) session.get("validateCode");
		if (!validatecode.equalsIgnoreCase(code)){
			message = "验证码错误";
			return "error";
		}
		ResultCode result = userService.register(user);
		switch (result) {
		case SUCCESS:
			return "UserregisterSuccess";
		case USERNAME_EXIST:
			message = "用户名已被占用";
			break;
		default:
			message  = "未知错误";
			break;
		}
		return "error";
	}
	
	public String modInfo(){
		try{
			userService.modInfo(user);
		}catch(Exception e){
			e.printStackTrace();
			return "error";
		}
		return "UsermodInfoSuccess";
	}
}
