package com.angular.todolist.repositories;

import com.angular.todolist.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.time.LocalDate;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{
	public Task findByTask(String task);
    public List<Task> findAll();
    public Task getById(int i);
    public Task findByExpiryDate(LocalDate expirydate);
    public Task findByDateCreated(LocalDate datecreated);

}
