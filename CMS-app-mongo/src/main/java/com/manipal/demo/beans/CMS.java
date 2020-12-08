package com.manipal.demo.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="countries")
public class CMS {
	
	@Id
	private int countryId;
	private String countryName;
	private int population;
	private String capital;
	private String language;
	
	public CMS() {}
	
	public CMS(int countryId, String countryName, int population, String capital, String language) {
		super();
		this.countryId = countryId;
		this.countryName = countryName;
		this.population = population;
		this.capital = capital;
		this.language = language;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	
	

}
 