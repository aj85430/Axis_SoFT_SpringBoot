package com.manipal.proxy;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.manipal.bean.UnitBean;

//@FeignClient(name="unit-conversion-service", url="localhost:8000")

//@FeignClient(name="unit-conversion-service")
@FeignClient(name="zuul-server")
@RibbonClient(name="unit-conversion-service")
public interface UnitConversionServiceProxy {

	@GetMapping("unit-conversion-service/unit-conversion/from/{fromUnit}/to/{toUnit}")
	public UnitBean retrieveConversionMultiple(@PathVariable("fromUnit") String fromUnit, @PathVariable("toUnit") String toUnit);
}
