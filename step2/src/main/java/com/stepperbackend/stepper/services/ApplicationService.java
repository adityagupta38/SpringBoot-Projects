package com.stepperbackend.stepper.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stepperbackend.stepper.models.Application;

import com.stepperbackend.stepper.repositories.ApplicationRepository;


@Service
public class ApplicationService {
	
	@Autowired
	private ApplicationRepository appRepository;
	
	public Application createNewApplication(Application application) {
		//country.setCountry_uuid(UUID.randomUUID());
		return appRepository.save(application);
	}
	
	public List<Application> getAllApplication() { return appRepository.findAll(); }
	
	public Application findApplicationById(UUID id) {
		return appRepository.getById(id);
	}
	
	public void deleteApplication(UUID id) {
		appRepository.deleteById(id);
	}

	public Application updateApplication(Application application) {
		return appRepository.save(application);
	}


}
