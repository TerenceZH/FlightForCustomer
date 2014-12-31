package com.dao;

import java.util.List;

import com.pojo.User;

public interface UserDao {
	
	
	public void insertOne(User user);
	
	public List<Long> getCountOfUser(User user);
	public List<Long> getCountOfUsername(User user);
	public User getOne(Long id);
	public User getOne(User user);

}
