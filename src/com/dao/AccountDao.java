package com.dao;

import java.util.List;

import com.pojo.Account;

public interface  AccountDao {
	
	public void addOne(Account account);
	
	public Account getOne(Long id);
	
	public List<Long> getCountOfAccount(Account account);
	
	public Account getOne(String account);

}
