package com.angular.todolist.models;




import java.time.LocalDate;
//import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;


@Entity // This tells Hibernate to make a table out of this class

public class Task {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    // this is the primary key which will be auto generated
	    private int id;
	 	
	 	@Column(name = "task", nullable = false, unique = true)
	    private String task;
	 	
	 	private LocalDate dateCreated;
	 	
	 	@Transient
	 	private boolean expired = false;
	 	
	 	@Transient
	 	private String remDays;
	 	
	 
	 	
	 	
	 	
	 	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	 	@Column(name = "expiryDate")
	  	private LocalDate expiryDate;
	   
	 	
	 // Mapping the column of this table
	    @ManyToOne
	    //Adding the name
	    @JoinColumn(name = "user_id", nullable = false)
	    private Users user;
	 	
	 	
	 	
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	 
	    
	    public String getTask() {
	        return task;
	    }
	    public void setTask(String task) {
	        this.task = task;
	    }
	   
	    public LocalDate getDateCreated() {
	    	return this.dateCreated;
	    }
	    
	    public void setDateCreated(LocalDate datecreated) {
	        this.dateCreated = datecreated;
	    }
	  
	    public LocalDate getExpiryDate() {
	    	return this.expiryDate;
	    }
	    public void setExpiryDate(LocalDate expirydate) {
	        this.expiryDate = expirydate;
	    }
	    public boolean getExpired() {
	        return this.expired;
	    }
	    
		public void setExpired(boolean b) {
			// TODO Auto-generated method stub
			this.expired = b;
			
		}
		
		 public String getRemDays() {
		        return remDays;
		    }
		    public void setRemDays(String remdays) {
		        this.remDays = remdays;
		    }
	    
}
