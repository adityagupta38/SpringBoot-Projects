package com.stepperbackend.stepper.models;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private UUID state_uuid;
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id",unique = true, nullable = false)
    private int state_id;
	
	
	@Column(name = "state_name",unique = true, nullable= false)
	private String state_name;
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "stateuser")
    private List<User> user;
	 
	@JsonIgnore 
	@ManyToOne
	@JoinColumn(name = "country_uuid", nullable = false)
	private Country country;
	
	

	public UUID getState_uuid() {
		return state_uuid;
	}

	public void setState_uuid(UUID state_uuid) {
		this.state_uuid = state_uuid;
	}

	public int getState_id() {
		return state_id;
	}

	public void setState_id(int state_id) {
		this.state_id = state_id;
	}

	public String getState_name() {
		return state_name;
	}

	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}
