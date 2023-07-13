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
import com.stepperbackend.stepper.models.Role;

import com.stepperbackend.stepper.models.User_Application_Role;
import com.stepperbackend.stepper.repositories.ApplicationRepository;
import com.stepperbackend.stepper.repositories.RoleRepository;
import com.stepperbackend.stepper.repositories.User_Application_Role_Repository;
import com.stepperbackend.stepper.services.User_Application_Role_Service;



@CrossOrigin(origins = { "http://localhost:4200/"})
@RestController
@RequestMapping("/userapprole")
public class User_Application_Role_Controller {
	
	@Autowired
    private User_Application_Role_Service userAppRoleService;
	
	@Autowired
	private User_Application_Role_Repository user_app_role_repo;
	
	@Autowired
	private ApplicationRepository apprepository;
	
	@Autowired
	private RoleRepository rolerepository;
	
	
	
    @GetMapping("/")
    public ResponseEntity<List<User_Application_Role>> getAllUserAppRole() {
    	
        return ResponseEntity.ok(userAppRoleService.getAllUserAppRole());
    }
    
    
    @PostMapping("/{app_uuid}/{role_uuid}")
    public ResponseEntity<Boolean> createUserAppRole(@RequestBody User_Application_Role userapprole, 
    		@PathVariable String app_uuid, @PathVariable String[] role_uuid) { 
    	
    	
    	
    	Application application = apprepository.getById(app_uuid);
    	/*
    	userapprole.setApplication(application);
    	Role role = rolerepository.getById(role_uuid);
    	userapprole.setRole(role);
    	
    	*/
    
    	
    	
    	
    	
    	for(String ruid: role_uuid) {
    		Role role = rolerepository.getById(ruid);
        	userapprole.setRole(role);
        	userapprole.setApplication(application);
        	
        	/*
        	List<User_Application_Role> uarlist =  user_app_role_repo.findAll();
            
        	int uar_id = uarlist.size();
        	
        	if (uarlist.isEmpty()) {
        		userapprole.setUser_application_role_id(1);
        	}
        	else {
        	
            	userapprole.setUser_application_role_id(uar_id + 1);
        	}
        	
        	*/
        	
        	user_app_role_repo.save(userapprole);
        	
        		//userAppRoleService.createNewUserAppRole(userapprole);
        	
        	
    	}
    	
    	
    	
    	//user_app_role_repo.save(userapprole);
    	
        return ResponseEntity.ok(true);  		
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<User_Application_Role> updateUserAppRole(@PathVariable String id, @RequestBody User_Application_Role userapprole) {
    	userapprole.setUser_application_role_uuid(id);
        return ResponseEntity.ok(userAppRoleService.updateUserAppRole(userapprole));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllUserAppRole(@PathVariable String id) {
    	userAppRoleService.deleteUserAppRole(id);
        return ResponseEntity.ok(true);
    }
}
