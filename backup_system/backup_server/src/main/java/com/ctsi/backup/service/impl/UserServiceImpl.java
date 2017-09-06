package com.ctsi.backup.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ctsi.backup.pojo.User;
import com.ctsi.backup.service.UserService;
import com.ctsi.backup.utils.UUIDUtils;
@Service("userService")
public class UserServiceImpl implements UserService{

	@Override
	public User add(User user) {
		user.setUuid(UUIDUtils.getUUID());
		return user;
	}

	@Override
	public User upate(User user) {
		user.setName(user.getName()+"newName");
		user.setAge(user.getAge()+10);
		return user;
	}

	@Override
	public User queryById(String id) {
		User user = new User();
		user.setUuid(id);
		user.setAge(10);
		user.setName(id);
		return user;
	}

	@Override
	public List<User> queryList(Map<String, String> map) {
		List<User> users = new ArrayList<User>();
		User user1 = new User();
		user1.setUuid("1");
		user1.setAge(10);
		user1.setName(map.get("name1"));
		users.add(user1);
		
		User user2 = new User();
		user2.setUuid("2");
		user2.setAge(20);
		user2.setName(map.get("name2"));
		users.add(user2);
		return users;
	}

	@Override
	public int delete(String id) {
		return 1;
	}

}
