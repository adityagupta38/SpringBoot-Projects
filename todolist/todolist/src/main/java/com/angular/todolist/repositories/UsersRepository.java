package com.angular.todolist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.angular.todolist.models.Users;


@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	public Users getById(int i);
	public List<Users> findAll();
	public Users findByUsername(String username);
}
