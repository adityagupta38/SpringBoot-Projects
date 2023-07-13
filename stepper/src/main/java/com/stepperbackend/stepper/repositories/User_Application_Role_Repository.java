package com.stepperbackend.stepper.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.stepperbackend.stepper.models.User_Application_Role;



@Repository
public interface User_Application_Role_Repository extends JpaRepository<User_Application_Role, String>{

}
