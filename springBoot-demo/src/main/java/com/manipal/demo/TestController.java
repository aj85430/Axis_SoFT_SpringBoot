package com.manipal.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TestController {

	@RequestMapping("/")
	public String homePage() {
	return "Welcome to Spring Boot";
		
	}
	
	@RequestMapping("/info")
	public String greeting() {
		return "Good Morning India";
		
	}
}
