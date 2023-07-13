package com.angular.todolist.controllers;

import com.angular.todolist.models.Task;
import com.angular.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.RestController;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@CrossOrigin(origins = { "http://localhost:4200/"})
@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
	@Autowired
    private TaskService taskService;
	
    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
    	
        return ResponseEntity.ok(taskService.getAllTask());
    }
    
    @PostMapping("/")
    public ResponseEntity<Task> createTask(@RequestBody Task task) { 	
   	
        return ResponseEntity.ok(taskService.createNewTask(task));  		
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task task) {
        task.setId(id);
        return ResponseEntity.ok(taskService.updateTask(task));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> getAllTasks(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }
    
    


}
