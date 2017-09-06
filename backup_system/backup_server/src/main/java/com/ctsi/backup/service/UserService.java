package com.ctsi.backup.service;

import java.util.List;
import java.util.Map;

import com.ctsi.backup.pojo.User;

public interface UserService {
	public User add(User user);
	
	public User upate(User user);
	
	public User queryById(String id);
	
	public List<User> queryList(Map<String,String> map);
	
	public int delete(String id);
}
