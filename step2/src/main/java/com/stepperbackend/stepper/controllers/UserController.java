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
import com.stepperbackend.stepper.models.State;
import com.stepperbackend.stepper.models.User;
import com.stepperbackend.stepper.repositories.CountryRepository;
import com.stepperbackend.stepper.repositories.StateRepository;
import com.stepperbackend.stepper.repositories.UserRepository;
import com.stepperbackend.stepper.services.UserService;

@CrossOrigin(origins = { "http://localhost:4200/"})
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
    private UserRepository userrepository;
	
	@Autowired
    private StateRepository stateRepository;
		
	@Autowired
	private CountryRepository countryRepository;
	
	
	
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser() {
    	
        return ResponseEntity.ok(userService.getAllUser());
    }
    
    
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
    	
    	/*
    	List<User> ulist =  userrepository.findAll();
    
    	//int u_id = ulist.size() + 1;
    	//user.setUser_id(u_id);
    	int u_id = ulist.size() + 1;
    	//user.setUser_id(u_id);
    	if (ulist.isEmpty()) {
    		user.setUser_id(1);
    	}
    	else {
    		//int u_id = ulist.size() + 1;
        	user.setUser_id(u_id);
    	}
    	*/
        return ResponseEntity.ok(userService.createNewUser(user));  		
    }
    
    @PostMapping("/{c_uuid}/{s_uuid}")
    public ResponseEntity<User> createUser(@RequestBody User user, @PathVariable UUID c_uuid, @PathVariable UUID s_uuid) { 	
    	Country country = countryRepository.getById(c_uuid);
    	user.setCountryuser(country);
    	State state = stateRepository.getById(s_uuid);
    	user.setStateuser(state);
        return ResponseEntity.ok(userService.createNewUser(user));  		
    }
    
       
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable UUID id, @RequestBody User user) {
        user.setUser_uuid(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(true);
    }

}
