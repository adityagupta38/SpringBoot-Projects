package com.stepperbackend.stepper.controllers;

import java.util.List;
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
import com.stepperbackend.stepper.services.CountryService;


@CrossOrigin(origins = { "http://localhost:4200/"})
@RestController
@RequestMapping("/country")
public class CountryController {
	
	@Autowired
    private CountryService countryService;
	
    @GetMapping("/")
    public ResponseEntity<List<Country>> getAllCountry() {
    	
        return ResponseEntity.ok(countryService.getAllCountry());
    }
    
    @PostMapping("/")
    public ResponseEntity<Country> createCountry(@RequestBody Country country) { 	
    
        return ResponseEntity.ok(countryService.createNewCountry(country));  		
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable UUID id, @RequestBody Country country) {
        country.setCountry_uuid(id);
        return ResponseEntity.ok(countryService.updateCountry(country));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllCountry(@PathVariable UUID id) {
        countryService.deleteCountry(id);
        return ResponseEntity.ok(true);
    }

}
