package com.stepperbackend.stepper.models;




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
public class User_Application_Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
    private String user_application_role_uuid;
	
	
	
	

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_uuid", nullable= false)
    //@RestResource(path = "libraryAddress", rel="address")
    private Application application;
	
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "role_uuid", nullable = false)
	 private Role role;

		public String getUser_application_role_uuid() {
			return user_application_role_uuid;
		}

		public void setUser_application_role_uuid(String user_application_role_uuid) {
			this.user_application_role_uuid = user_application_role_uuid;
		}

		public Application getApplication() {
			return application;
		}

		public void setApplication(Application application) {
			this.application = application;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

	 	
	 	
}
