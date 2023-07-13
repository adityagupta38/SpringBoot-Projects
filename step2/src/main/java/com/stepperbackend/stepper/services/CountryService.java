package com.stepperbackend.stepper.services;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stepperbackend.stepper.models.Country;
import com.stepperbackend.stepper.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository countryRepository;
	
	public Country createNewCountry(Country country) {
		//country.setCountry_uuid(UUID.randomUUID());
		return countryRepository.save(country);
	}
	
	public List<Country> getAllCountry() { return countryRepository.findAll(); }
	
	public Country findCountryById(UUID id) {
		return countryRepository.getById(id);
	}
	
	public void deleteCountry(UUID id) {
		countryRepository.deleteById(id);
	}

	public Country updateCountry(Country country) {
		return countryRepository.save(country);
	}

}
