package com.service.impl;

import java.util.List;





import org.springframework.beans.BeanUtils;

import com.common.ResultCode;
import com.dao.UserDao;
import com.exception.DaoException;
import com.pojo.User;
import com.service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	

	

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public ResultCode login(User user) {
		// TODO Auto-generated method stub
		List<Long> list = userDao.getCountOfUser(user);
		if(list.get(0)==1){
			return ResultCode.SUCCESS;
		}else {
			return ResultCode.USERNAME_NOTEXIST;
		}
	}

	@Override
	public ResultCode register(User user) {
		// TODO Auto-generated method stub
		if(userDao.getCountOfUsername(user).get(0)==1){
			return ResultCode.USERNAME_EXIST;
		}else {
			userDao.insertOne(user);
			return ResultCode.SUCCESS;
		}
		
	}

	@Override
	public ResultCode modInfo(User user) {
		// TODO Auto-generated method stub
		User oldUser  = userDao.getOne(user.getId());
		BeanUtils.copyProperties(user, oldUser);
		return ResultCode.SUCCESS;
	}

	@Override
	public User getUser(User user){
		return userDao.getOne(user);
	}
	
}
