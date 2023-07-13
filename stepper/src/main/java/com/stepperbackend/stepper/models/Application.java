package com.stepperbackend.stepper.models;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.JdbcType;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	//@Column(name = "application_uuid", columnDefinition = "VARCHAR(255)")
    private String application_uuid;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "application_id",unique = true, nullable = false)
    private int application_id;
	
	
	@Column(name = "application_name",unique = true, nullable= false)
	private String application_name;
	
	@JsonIgnore
	@OneToMany(mappedBy = "application")
    private List<User_Application_Role> user_app_role;

	public String getApplication_uuid() {
		return application_uuid;
	}

	public void setApplication_uuid(String application_uuid) {
		this.application_uuid = application_uuid;
	}

	public int getApplication_id() {
		return application_id;
	}

	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}

	public String getApplication_name() {
		return application_name;
	}

	public void setApplication_name(String application_name) {
		this.application_name = application_name;
	}

	public List<User_Application_Role> getUser_app_role() {
		return user_app_role;
	}

	public void setUser_app_role(List<User_Application_Role> user_app_role) {
		this.user_app_role = user_app_role;
	}
	
	

	

}
