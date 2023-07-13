package com.stepperbackend.stepper;




import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stepperbackend.stepper.models.User;
import com.stepperbackend.stepper.repositories.UserRepository;



@SpringBootApplication
public class StepperApplication implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	private static Logger LOG = LoggerFactory
		      .getLogger(SpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(StepperApplication.class, args);
	}
	
	@Override
    public void run(String... args) {
        LOG.info("EXECUTING : command line runner");
 
        for (int i = 0; i < args.length; ++i) {
            LOG.info("args[{}]: {}", i, args[i]);
        }
        
        
        
    	
    	
    	
    	List<User>  userlist = userRepository.findAll();
    	
    	System.out.println(userlist);
    	int ulen =  userlist.size();
    	System.out.println(ulen);
        
        
        
	}
	
	
	

}
