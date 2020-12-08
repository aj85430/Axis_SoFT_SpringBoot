package com.manipal.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.beans.WelcomeBean;


@RestController
public class GreetingController {

	
	//@RequestMapping(value= "/welcome",method=RequestMethod.GET)
	@GetMapping("/welcome")
	public String welcome() {
	return "Hi folks! Let's Start!!";
	}
	
	@GetMapping("/welcome/{userName}/{location}")
	public String welcomeName(@PathVariable("userName") String name, @PathVariable String location) {
	return "Hi "+ name +" Let's Start!! @"+ location ;
	}
	
	@GetMapping("/welcomeobj")
	public WelcomeBean welcomeObject() {
	return new WelcomeBean("Good Job Folks");
	}
	
}
