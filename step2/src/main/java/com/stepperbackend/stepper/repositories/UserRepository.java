package com.stepperbackend.stepper.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.stepperbackend.stepper.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, UUID>{

}
