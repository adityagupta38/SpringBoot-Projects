package com.stepperbackend.stepper.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepperbackend.stepper.models.Role;

import com.stepperbackend.stepper.repositories.RoleRepository;




@Service
public class RoleService {
	
	@Autowired
	private RoleRepository roleRepository;
	
	public Role createNewRole(Role role) {
		//country.setCountry_uuid(UUID.randomUUID());
		return roleRepository.save(role);
	}
	
	public List<Role> getAllRole() { return roleRepository.findAll(); }
	
	public Role findRoleById(UUID id) {
		return roleRepository.getById(id);
	}
	
	public void deleteRole(UUID id) {
		roleRepository.deleteById(id);
	}

	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}

}
