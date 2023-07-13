package com.angular.todolist.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.angular.todolist.models.Users;
import com.angular.todolist.repositories.UsersRepository;




@Service
public class UsersService {
	
	@Autowired
	public static UsersRepository usersRepository;
	
	@Autowired
	public static UsersService userservice;
	
	public Users createUser(Users user) {
		

		return usersRepository.save(user);
	}

	
	public List<Users> getAllUsers() { return usersRepository.findAll(); }
	
	
	public Users findUserById(int id) {
		return usersRepository.getById(id);
	}

	public void deleteUser(int id) {
		usersRepository.deleteById(id);
	}

	public Users updateUser(Users user) {
		return usersRepository.save(user);
	}
	
	static Users findUserByUsername(String username) {
		return usersRepository.findByUsername(username);
	}
	
	public boolean validateUser(String username, String password) {
		System.out.println(username);
		Users user = usersRepository.findByUsername(username);
		System.out.println(user);
		if (user.getUserName() == username && user.getPassword() == password) {
			return true;	
		}
		else {
			return false;
		}
		
	}
	 
}
