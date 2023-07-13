package com.stepperbackend.stepper.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stepperbackend.stepper.models.User;

import com.stepperbackend.stepper.repositories.UserRepository;



@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User createNewUser(User user) {
		//country.setCountry_uuid(UUID.randomUUID());
		return userRepository.save(user);
	}
	
	public List<User> getAllUser() { return userRepository.findAll(); }
	
	public User findUserById(String id) {
		return userRepository.getById(id);
	}
	
	public void deleteUser(String id) {
		userRepository.deleteById(id);
	}

	public User updateUser(User user) {
		return userRepository.save(user);
	}


}
