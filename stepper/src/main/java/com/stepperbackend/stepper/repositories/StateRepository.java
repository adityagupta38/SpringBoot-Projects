package com.stepperbackend.stepper.repositories;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stepperbackend.stepper.models.Country;
import com.stepperbackend.stepper.models.State;




@Repository
public interface StateRepository extends JpaRepository<State, String>{
	
	
	List<State> findAllByCountry(Country country);

}
