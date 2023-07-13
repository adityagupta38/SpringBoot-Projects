package com.stepperbackend.stepper.models;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonFormat;
//import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;




@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    //@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
   // @Column(name = "user_uuid", columnDefinition = "VARCHAR(255)")
    private String user_uuid;
	
	@JsonIgnore
	@Column(name = "user_id",unique = true)
	//@GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;
	
	
	@Column(name = "first_name",nullable= false)
	private String first_name;
	
	@Column(name = "last_name",nullable= false)
	private String last_name;
	
	@Column(name = "email",nullable= false)
	private String email;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
 	@Column(name = "dateofbirth")
  	private LocalDate dateofbirth;
	
	@Column(name = "gender",nullable= false)
	private String gender;
	
		@JsonIgnore
	 	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "contry_uuid")
	    //@RestResource(path = "libraryAddress", rel="address")
	    private Country countryuser;
	  	
		@JsonIgnore
	 	@ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "state_uuid")
	    //@RestResource(path = "libraryAddress", rel="address")
	    private State stateuser;

		public String getUser_uuid() {
			return user_uuid;
		}

		public void setUser_uuid(String user_uuid) {
			this.user_uuid = user_uuid;
		}

		public int getUser_id() {
			return user_id;
		}

		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}

		public String getFirst_name() {
			return first_name;
		}

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public LocalDate getDateofbirth() {
			return dateofbirth;
		}

		public void setDateofbirth(LocalDate dateofbirth) {
			this.dateofbirth = dateofbirth;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		

		public Country getCountryuser() {
			return countryuser;
		}

		public void setCountryuser(Country countryuser) {
			this.countryuser = countryuser;
		}

		public State getStateuser() {
			return stateuser;
		}

		public void setStateuser(State stateuser) {
			this.stateuser = stateuser;
		}

	  	
	  
	  	
	  
}
