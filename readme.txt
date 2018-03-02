Load balance - Feign

Feign need one interface and add annotation to that interface

and interface should be same to the dependent service method

dependent service(service-user)
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

Feign interface
@FeignClient("service-user")
public interface IUserService {
	
	@RequestMapping("/getUser")
	public User getUserById(@RequestParam("id") int id);
	
}

NOTES:
1. Normally for every dependent service we need to create corresponding service to represent dependent service
2. @RequestParam("id") must added even though the method parameter same to this requestparam otherwise it will pop error



Circuit breaker - Hystrix
By Default, feign company with Hystrix. so no more jar need to be included. only need configure
fallback class and create one fallback class and annotated with @Service

no need to add feign.hystrix.enabled: false. i read this from some webpage. however looks like in higher version no need to include


Hystrix DashBoard
need to add maven dependency
<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>

@EnableHystrixDashboard
@EnableCircuitBreaker

http://localhost:8762/hystrix
stream set as http://localhost:8762/hystrix.stream 
title can be any word

however this only can see one service, we definitely need to use one tool includes all dependent service









