package com.stepperbackend.stepper.controllers;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stepperbackend.stepper.models.Country;
import com.stepperbackend.stepper.models.State;
import com.stepperbackend.stepper.repositories.CountryRepository;
import com.stepperbackend.stepper.repositories.StateRepository;
import com.stepperbackend.stepper.services.CountryService;
import com.stepperbackend.stepper.services.StateService;

@CrossOrigin(origins = { "http://localhost:4200/"})
@RestController
@RequestMapping("/state")
public class StateController {
	
	@Autowired
    private StateService stateService;
	
	@Autowired
    private StateRepository stateRepository;
	
	
	
	@Autowired
	private CountryRepository countryRepository;
	
    @GetMapping("/")
    public ResponseEntity<List<State>> getAllState() {
    	
        return ResponseEntity.ok(stateService.getAllState());
    }
    
    @GetMapping("/{coun_uuid}")
    public ResponseEntity<List<State>> getAllStateByCountry_uuid (@PathVariable UUID coun_uuid) {
    	Country country = countryRepository.getById(coun_uuid);
    	  	
        return ResponseEntity.ok(stateRepository.findAllByCountry(country));
    }
    
    
    
    @PostMapping("/{uuid}")
    public ResponseEntity<State> createState(@RequestBody State state, @PathVariable UUID uuid) { 	
    	//final CountryRepository countryrepo = null;
    	//Country country = countryservice.findCountryById( UUID.fromString(state.getCountry_uuid()));
    	Country country = countryRepository.getById(uuid);
    	state.setCountry(country);
        return ResponseEntity.ok(stateService.createNewState(state));  		
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<State> updateState(@PathVariable UUID id, @RequestBody State state) {
        state.setState_uuid(id);
        return ResponseEntity.ok(stateService.updateState(state));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllState(@PathVariable UUID id) {
        stateService.deleteState(id);
        return ResponseEntity.ok(true);
    }
	

}
