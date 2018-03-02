package com.ymd.learn.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ymd.learn.entity.User;

@FeignClient(value="service-user", fallback=UserServiceFeignHystrix.class)
public interface IUserService {
	
	@RequestMapping("/getUser")
	public User getUserById(@RequestParam("id") int id);
	
}
