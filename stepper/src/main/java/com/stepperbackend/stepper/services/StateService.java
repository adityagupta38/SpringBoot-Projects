package com.stepperbackend.stepper.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stepperbackend.stepper.models.State;

import com.stepperbackend.stepper.repositories.StateRepository;



@Service
public class StateService {
	
	@Autowired
	private StateRepository stateRepository;
	

	
	public State createNewState(State state) {
		//country.setCountry_uuid(UUID.randomUUID());
		return stateRepository.save(state);
	}
	
	public List<State> getAllState() { return stateRepository.findAll(); }
	
	public State findStateById(String id) {
		return stateRepository.getById(id);
	}
	
	public void deleteState(String id) {
		stateRepository.deleteById(id);
	}

	public State updateState(State state) {
		return stateRepository.save(state);
	}


}
