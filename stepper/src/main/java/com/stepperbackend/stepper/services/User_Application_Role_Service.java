package com.stepperbackend.stepper.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stepperbackend.stepper.models.User_Application_Role;

import com.stepperbackend.stepper.repositories.User_Application_Role_Repository;




@Service
public class User_Application_Role_Service {
	
	@Autowired
	private User_Application_Role_Repository userAppRoleRepo;
	
	public User_Application_Role createNewUserAppRole(User_Application_Role userapprole) {
		//country.setCountry_uuid(UUID.randomUUID());
		return userAppRoleRepo.save(userapprole);
	}
	
	public List<User_Application_Role> getAllUserAppRole() { return userAppRoleRepo.findAll(); }
	
	public User_Application_Role findUserAppRoleById(String id) {
		return userAppRoleRepo.getById(id);
	}
	
	public void deleteUserAppRole(String id) {
		userAppRoleRepo.deleteById(id);
	}

	public User_Application_Role updateUserAppRole(User_Application_Role userapprole) {
		return userAppRoleRepo.save(userapprole);
	}


}
