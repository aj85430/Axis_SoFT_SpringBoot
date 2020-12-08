package com.manipal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.bean.UnitBean;
import com.manipal.proxy.UnitConversionServiceProxy;

@RestController
public class UnitCalculationController {
	
	/*@GetMapping("unit-calculation/from/{fromUnit}/to/{toUnit}/quantity/{quantity}")
	public double calculate(@PathVariable String fromUnit, @PathVariable String toUnit, @PathVariable double quantity)
	{
		double finalValue=1000* quantity;
		return finalValue;
	}*/
	
	@Autowired
	private UnitConversionServiceProxy proxy;
	
	@GetMapping("unit-calculation/from/{fromUnit}/to/{toUnit}/quantity/{quantity}")
	public UnitBean calculate(@PathVariable String fromUnit, @PathVariable String toUnit, @PathVariable double quantity)
	{
		UnitBean unit= proxy.retrieveConversionMultiple(fromUnit, toUnit);
		
		double convertedValue= unit.getConversionMultiple() * quantity;
		unit.setQuantity(quantity);
		unit.setConvertedValue(convertedValue);
		
		
		return unit;
	}
	
	/*@GetMapping("unit-calculation/from/{fromUnit}/to/{toUnit}/quantity/{quantity}")
	public double calculate(@PathVariable String fromUnit, @PathVariable String toUnit, @PathVariable double quantity)
	{
		double conversionMultiple= proxy.retrieveConversionMultiple(fromUnit, toUnit);
		double finalValue= conversionMultiple * quantity;
		return finalValue;
	}*/

}
