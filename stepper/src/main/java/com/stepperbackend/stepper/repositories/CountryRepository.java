package com.stepperbackend.stepper.repositories;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.stepperbackend.stepper.models.Country;



@Repository
public interface CountryRepository extends JpaRepository<Country, String>{
	
	@Autowired
	
	 public Country getById(String i);
	

}
