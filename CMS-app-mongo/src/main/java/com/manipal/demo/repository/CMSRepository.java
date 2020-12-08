package com.manipal.demo.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.manipal.demo.beans.CMS;



@Repository
public interface CMSRepository extends MongoRepository<CMS, Integer> {

	

	List<CMS> findByLanguage(String language);
	
	@Query("{'population': {$gt:?0}}")
	List<CMS> findByPopulation(int population);
	
	@Query("{'countryName': '?0'}")
	CMS findCountryDetailsByName(String countryName);

}
