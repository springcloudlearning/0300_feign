package com.ymd.learn.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ymd.learn.entity.User;
import com.ymd.learn.service.IUserService;

@RestController
public class HiController {
	
	@Autowired
	IUserService iUserService;
	
	@RequestMapping("/hi")
	public User sayHiById(@RequestParam int id) {
		System.out.println("-------");
		return this.iUserService.getUserById(id);
	}
	
	
	
	
}
