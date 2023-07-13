package com.angular.todolist.models;

import jakarta.persistence.*;

import java.util.Set;



@Entity
@Table(name = "users")
public class Users {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@Column(name = "username", nullable = false, unique = true)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	// Mapping to the other table
    @OneToMany(cascade = CascadeType.ALL, mappedBy="user")
    private Set<Task> tasks;
    
    
    public int getId(int id) {
		// TODO Auto-generated method stub
    	return this.id;
		
	}
    
    
    
    public void setId(int id) {
		// TODO Auto-generated method stub
    	this.id = id;
		
	}
    
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getUserName() {
    	return this.username;
    }
    
    public void setUserName(String username) {
    	this.username = username;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }

	
	
	

}
