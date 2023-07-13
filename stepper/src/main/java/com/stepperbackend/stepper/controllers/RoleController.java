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


import com.stepperbackend.stepper.models.Role;

import com.stepperbackend.stepper.repositories.RoleRepository;
import com.stepperbackend.stepper.services.RoleService;

@CrossOrigin(origins = { "http://localhost:4200/"})
@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
    private RoleService roleService;
	
	@Autowired
    private RoleRepository roleRepository;
	
    @GetMapping("/")
    public ResponseEntity<List<Role>> getAllRole() {
    	
        return ResponseEntity.ok(roleService.getAllRole());
    }
    
    @PostMapping("/")
    public ResponseEntity<Role> createCountry(@RequestBody Role role) { 
    	
    	List<Role> rlist =  roleRepository.findAll();
        
    	int r_id = rlist.size();
    	
    	if (rlist.isEmpty()) {
    		role.setRole_id(1);
    	}
    	else {
    	
        	role.setRole_id(r_id + 1);
    	}
    	
    
        return ResponseEntity.ok(roleService.createNewRole(role));  		
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateRole(@PathVariable String id, @RequestBody Role role) {
        role.setRole_uuid(id);
        return ResponseEntity.ok(roleService.updateRole(role));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllRole(@PathVariable String id) {
        roleService.deleteRole(id);
        return ResponseEntity.ok(true);
    }

}
