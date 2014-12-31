package com.service;

import com.common.ResultCode;
import com.pojo.User;

public interface UserService {
	
	public ResultCode login(User user);
	public ResultCode register(User user);
	public ResultCode modInfo(User user);
	public User getUser(User user);

}
