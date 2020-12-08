package com.manipal.demo.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

//@JsonRootName(value="welcome")
//@JavaBean
public class WelcomeBean {
	
	//@JsonProperty
	private String message;

	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public WelcomeBean() {}
	public WelcomeBean(String message) {
		super();
		this.message = message;
	}
	
	

}
