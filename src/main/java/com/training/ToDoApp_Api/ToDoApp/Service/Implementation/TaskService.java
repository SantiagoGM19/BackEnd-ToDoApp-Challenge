package com.training.ToDoApp_Api.ToDoApp.Service.Implementation;

import com.training.ToDoApp_Api.ToDoApp.Entity.Task;
import com.training.ToDoApp_Api.ToDoApp.Repository.TaskRepository;
import com.training.ToDoApp_Api.ToDoApp.Service.Interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TaskService implements ITaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
