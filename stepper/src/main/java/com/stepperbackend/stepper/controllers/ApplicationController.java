package com.stepperbackend.stepper.controllers;

import java.util.List;


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

import com.stepperbackend.stepper.models.Application;

import com.stepperbackend.stepper.repositories.ApplicationRepository;
import com.stepperbackend.stepper.services.ApplicationService;



@CrossOrigin(origins = { "http://localhost:4200/"})
@RestController
@RequestMapping("/application")
public class ApplicationController {
	
	@Autowired
    private ApplicationService appService;
	
	@Autowired
    private ApplicationRepository appRepository;
	
    @GetMapping("/")
    public ResponseEntity<List<Application>> getAllApplication() {
    	
        return ResponseEntity.ok(appService.getAllApplication());
    }
    
    @PostMapping("/")
    public ResponseEntity<Application> createCountry(@RequestBody Application app) { 
    	
    	List<Application> alist =  appRepository.findAll();
        
    	int a_id = alist.size();
    	
    	if (alist.isEmpty()) {
    		app.setApplication_id(1);
    	}
    	else {
    	
        	app.setApplication_id(a_id + 1);
    	}
    
        return ResponseEntity.ok(appService.createNewApplication(app));  		
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Application> updateRole(@PathVariable String id, @RequestBody Application app) {
        app.setApplication_uuid(id);
        return ResponseEntity.ok(appService.updateApplication(app));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllApplication(@PathVariable String id) {
        appService.deleteApplication(id);
        return ResponseEntity.ok(true);
    }

}
