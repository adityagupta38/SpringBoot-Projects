package com.stepperbackend.stepper.models;

import java.util.List;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class Country {
	

    
    // this is the primary key which will be auto generated
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private String country_uuid;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id",unique = true, nullable = false)
    private int country_id;
	
	@Column(name = "country_name",unique = true, nullable= false)
	private String country_name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="country")
    private List<State> state;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "countryuser")
    private List<User> user;

	public String getCountry_uuid() {
		return country_uuid;
	}

	public void setCountry_uuid(String country_uuid) {
		this.country_uuid = country_uuid;
	}

	public int getCountry_id() {
		return country_id;
	}

	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public List<State> getState() {
		return state;
	}

	public void setState(List<State> state) {
		this.state = state;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	

}
