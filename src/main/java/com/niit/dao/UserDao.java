package com.niit.dao;

import com.niit.model.User;

public interface UserDao {
	
	public void insertOrUpdateUser(User user);
	public User getUser(String name);
	public String getUserName(String email);
	public String getUserAddress(String email);
	public String getUserPhone(String email);
}
