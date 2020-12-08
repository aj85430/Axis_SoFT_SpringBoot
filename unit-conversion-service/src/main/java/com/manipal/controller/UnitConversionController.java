package com.manipal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.bean.ConversionRate;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class UnitConversionController {
	
	/*@GetMapping("unit-conversion/from/{fromUnit}/to/{toUnit}")
	public Double getConversionRate(@PathVariable String fromUnit, @PathVariable String toUnit) {
		
		ConversionRate conversionRate= new ConversionRate(fromUnit, toUnit, 1000);
		return 1000.00;
		
	}*/
	
	@Autowired
	private Environment environment;
	
	@GetMapping("unit-conversion/from/{fromUnit}/to/{toUnit}")
	@HystrixCommand(fallbackMethod = "getConversionRateFallback")
	public ConversionRate getConversionRate(@PathVariable String fromUnit, @PathVariable String toUnit) {
		double conversionMultiple=1000.00;
		String port=environment.getProperty("server.port");
		ConversionRate conversionRate= new ConversionRate( fromUnit, toUnit, conversionMultiple,port);
		throw new RuntimeException();
		//return conversionRate;
	}
	
	public ConversionRate getConversionRateFallback(@PathVariable String fromUnit, @PathVariable String toUnit) {
		String port=environment.getProperty("server.port");
		ConversionRate conversionRate= new ConversionRate("Fallback- "+ fromUnit, toUnit, 1000,port);
		return conversionRate;
	}
		
	

}
