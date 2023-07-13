package com.stepperbackend.stepper.models;

import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;


@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private String role_uuid;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id",unique = true, nullable = false)
    private int role_id;
	
	
	@Column(name = "role_name",unique = true, nullable= false)
	private String role_name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="role")
    private Set<User_Application_Role> user_app_role;

	public String getRole_uuid() {
		return role_uuid;
	}

	public void setRole_uuid(String role_uuid) {
		this.role_uuid = role_uuid;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public Set<User_Application_Role> getUser_app_role() {
		return user_app_role;
	}

	public void setUser_app_role(Set<User_Application_Role> user_app_role) {
		this.user_app_role = user_app_role;
	}
	
	
    
	
	

}
