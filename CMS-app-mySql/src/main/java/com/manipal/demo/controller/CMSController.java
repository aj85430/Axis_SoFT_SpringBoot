package com.manipal.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manipal.demo.beans.CMS;

import com.manipal.demo.service.CMSService;



@RestController
public class CMSController {
	
	
	@Autowired
	CMSService cmsService;

	@GetMapping("/countries")
	public List<CMS> displayCountries() 
	{
		return  cmsService.getAllCountry();
	}
	
	@GetMapping("/countries/{countryId}")
	public CMS displayCountryById(@PathVariable Integer countryId){			
		return cmsService.getCountry(countryId);
	}
	
	@PostMapping("/countries")
	public ResponseEntity<CMS> addNewCountry(@RequestBody CMS cms) {
		
		CMS country= cmsService.addCountry(cms);
		HttpHeaders headers = new HttpHeaders();
		headers.add("response-form", "CMSController");
		return new ResponseEntity(country,headers,HttpStatus.OK);
	}
	
	@DeleteMapping("/countries/{countryId}")
	public void deleteCountry(@PathVariable Integer countryId) {
		cmsService.deleteCountry(countryId);
	}
	
	@PutMapping("/countries/{countryId}")
	public ResponseEntity<CMS> updateCountry(@PathVariable int countryId, @RequestBody CMS countryDetails) {
		
		CMS cms= cmsService.getCountry(countryId);
		cms.setCountryName(countryDetails.getCountryName());
		
		cms.setCapital(countryDetails.getCapital());
		cms.setPopulation(countryDetails.getPopulation());
		cms.setLanguage(countryDetails.getLanguage());
		
		
		
		CMS cmsUpdated= cmsService.addOrUpdateCountry(cms);
		
		
		return  ResponseEntity.ok(cmsUpdated);
	} 
	
	@GetMapping("/country/{language}/countries")
	public List<CMS> retriveCountries(@PathVariable String language) {
		return cmsService.getAllCountryByLanguage(language);
	}
	

}
