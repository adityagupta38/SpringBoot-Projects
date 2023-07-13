package com.stepperbackend.stepper.repositories;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stepperbackend.stepper.models.Country;
import com.stepperbackend.stepper.models.State;




@Repository
public interface StateRepository extends JpaRepository<State, UUID>{
	
	
	List<State> findAllByCountry(Country country);

}
