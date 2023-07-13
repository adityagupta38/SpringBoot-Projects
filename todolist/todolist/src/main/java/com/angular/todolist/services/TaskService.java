package com.angular.todolist.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.todolist.models.Task;
import com.angular.todolist.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task createNewTask(Task task) {
		LocalDate currentdate = LocalDate.now();
		task.setDateCreated(currentdate);

		return taskRepository.save(task);
	}

	/*
	 * 
	 * public List<Task> getAllTask() { return taskRepository.findAll(); }
	 * 
	 */

	public List<Task> getAllTask() {
		LocalDate currdate = LocalDate.now();
		ArrayList<Task> resultarray = new ArrayList<Task>();
		List<Task> taskarray = taskRepository.findAll();
		for (Task task : taskarray) {
			LocalDate expirydt = task.getExpiryDate();
			long diffDays = ChronoUnit.DAYS.between(expirydt, currdate);
			int compval = expirydt.compareTo(currdate);
			if (compval < 0) {
				task.setExpired(true);
				task.setRemDays("0");
			} else {
				task.setExpired(false);
				task.setRemDays(String.format("%s", Math.abs((int) diffDays) + 1));
			}
			resultarray.add(task);
		}

		return resultarray;
	}

	public Task findTaskById(int id) {
		return taskRepository.getById(id);
	}

	public void deleteTask(int id) {
		taskRepository.deleteById(id);
	}

	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}

	public Task findTaskByExpiryDate(LocalDate expirydate) {
		return taskRepository.findByExpiryDate(expirydate);
	}

}
