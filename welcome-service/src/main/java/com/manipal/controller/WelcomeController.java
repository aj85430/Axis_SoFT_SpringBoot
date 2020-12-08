package com.manipal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	
	@GetMapping("welcome/{name}")
	public String welcomeAll(@PathVariable String name) {
		return "Welcome...."+name;
	}

}
