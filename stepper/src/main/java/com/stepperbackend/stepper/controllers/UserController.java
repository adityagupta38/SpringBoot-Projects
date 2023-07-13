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
	private UserRepository userRepository;
	
	
	@Autowired
    private StateRepository stateRepository;
		
	@Autowired
	private CountryRepository countryRepository;
	
	
	
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUser() {
    	
        return ResponseEntity.ok(userService.getAllUser());
    }
    
    /*
    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.createNewUser(user));  		
    }
  */  
    @PostMapping("/{c_uuid}/{s_uuid}")
    public ResponseEntity<User> createUser(@RequestBody User user, @PathVariable String c_uuid, @PathVariable String s_uuid) { 	
    	Country country = countryRepository.getById(c_uuid);
    	user.setCountryuser(country);
    	State state = stateRepository.getById(s_uuid);
    	user.setStateuser(state);
    	
    	List<User> ulist =  userRepository.findAll();
        
    	int u_id = ulist.size();
    	
    	if (ulist.isEmpty()) {
    		user.setUser_id(1);
    	}
    	else {
    	
        	user.setUser_id(u_id + 1);
    	}
    	
        return ResponseEntity.ok(userService.createNewUser(user));  		
    }
    
       
    
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user) {
        user.setUser_uuid(id);
        return ResponseEntity.ok(userService.updateUser(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(true);
    }

}
