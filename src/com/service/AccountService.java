package com.service;

import com.common.ResultCode;
import com.pojo.Account;

public interface AccountService {
	
	public ResultCode loginAccount(Account account);
	public ResultCode payAccount(Account account,double money);
	public Account getAccount(String account);
}
