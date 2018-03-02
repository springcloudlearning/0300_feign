package com.ymd.learn.service;

import org.springframework.stereotype.Service;

import com.ymd.learn.entity.User;

@Service
public class UserServiceFeignHystrix implements IUserService {

	@Override
	public User getUserById(int id) {
		User user = new User();
		user.setName("Anonymous Name");
		return user;
	}

}
