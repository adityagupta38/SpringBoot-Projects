package com.stepperbackend.stepper.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stepperbackend.stepper.models.Application;


@Repository
public interface ApplicationRepository extends JpaRepository<Application, String>{

}
