package com.stepperbackend.stepper.repositories;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.stepperbackend.stepper.models.Country;



@Repository
public interface CountryRepository extends JpaRepository<Country, UUID>{
	
	@Autowired
	
	 public Country getById(UUID i);
	

}
