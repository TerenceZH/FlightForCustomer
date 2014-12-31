package com.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;

import com.common.ResultCode;
import com.dao.AccountDao;
import com.pojo.Account;
import com.service.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountDao accountDao;
	
	

	

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	@Override
	public ResultCode loginAccount(Account account) {
		// TODO Auto-generated method stub
		List<Long> list = accountDao.getCountOfAccount(account);
		if(list.get(0)==1){
			return ResultCode.SUCCESS;
		}else {
			return ResultCode.ACCOUNT_NOTEXIST;
		}
	}

	@Override
	public ResultCode payAccount(Account account,double money) {
		// TODO Auto-generated method stub
		double rest = account.getBalance()-money;
		System.out.println(rest);
		if(rest<0){
			return ResultCode.ACCOUNT_REST_OUT;
		}
		account.setBalance(rest);
		Account oldAccount = accountDao.getOne(account.getId());
		BeanUtils.copyProperties(account, oldAccount);
		return ResultCode.SUCCESS;
	}

	@Override
	public Account getAccount(String account) {
		// TODO Auto-generated method stub
		return accountDao.getOne(account);
	}

}
