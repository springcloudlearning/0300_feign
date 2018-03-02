package com.ymd.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ymd.learn.entity.User;

@RestController
public class UserController {

	@Value("${server.port}")
	int port;
	
	@RequestMapping("/getUser")
	public User getUserById(@RequestParam int id) {
		User user = new User();
		user.setId(id);
		user.setName("michael");
		user.setAge(33);
		user.setPort(port);
		return user;
	}
}
