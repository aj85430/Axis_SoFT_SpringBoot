package com.manipal.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manipal.demo.beans.CMS;
import com.manipal.demo.exception.CountryNotFoundException;

import com.manipal.demo.repository.CMSRepository;


@Service
public class CMSService {

	@Autowired
	private CMSRepository cmsRepository;
	
	public List<CMS> getAllCountry(){
		return cmsRepository.findAll();
	}
	
	public CMS getCountry(Integer id){
		return cmsRepository.findById(id).orElseThrow(()->new CountryNotFoundException("Country details not found for id "+ id));
	}
	
	public CMS addCountry(CMS cms){
		
		return cmsRepository.save(cms);
		
	}
	
	public void deleteCountry(Integer id) {
		cmsRepository.deleteById(id);		
	}
	
	public CMS addOrUpdateCountry(CMS cms)
	{
		return cmsRepository.save(cms);
	}
	
	public List<CMS> getAllCountryByLanguage(String language)
	{
		return cmsRepository.findByLanguage(language);
	}

	public List<CMS> getAllCountryByPopulation(int population) {
		
		return cmsRepository.findByPopulation(population);
	}


	public CMS getCountryDetailsByName(String countryName) {
		
		
		CMS cms=  cmsRepository.findCountryDetailsByName(countryName);
		
		if(cms==null) {
			
			throw(new CountryNotFoundException("Country is not found"));
		}
		return cms;
		
		
	}
	
	
	
	
	
}
