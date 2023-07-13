package com.angular.todolist.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.angular.todolist.models.Users;
import com.angular.todolist.repositories.UsersRepository;
import com.angular.todolist.controllers.Login;
import com.angular.todolist.services.UsersService;



@CrossOrigin(origins = { "http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1/users")
public class UsersController {
	
	@Autowired
    private UsersService usersService;
	@Autowired
	private UsersRepository usersRepository;
	
	
	@GetMapping("/")
    public ResponseEntity<List<Users>> getAllUsers() {
    	
        return ResponseEntity.ok(usersService.getAllUsers());
    }
	
	@PostMapping("/")
    public ResponseEntity<Users> createUser(@RequestBody Users user) { 	
   	
        return ResponseEntity.ok(usersService.createUser(user));  		
    }
	
	@PostMapping(value = "/login", consumes="application/json", produces="application/json")
    public ResponseEntity<Boolean> validateUser(@RequestBody Login login) { 
		String username = login.getUsername();
		String password = login.getPassword();
		System.out.println(username);
		System.out.println(password);
		
   	//System.out.println(this.username, this.password);
        return ResponseEntity.ok(usersService.validateUser(username,password));  		
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable int id, @RequestBody Users user) {
        user.setId(id);
        return ResponseEntity.ok(usersService.updateUser(user));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllUsers(@PathVariable int id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok(true);
    }
	
	

}
