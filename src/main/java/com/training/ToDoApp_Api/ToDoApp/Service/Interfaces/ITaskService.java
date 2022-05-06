package com.training.ToDoApp_Api.ToDoApp.Service.Interfaces;

import com.training.ToDoApp_Api.ToDoApp.Entity.Category;
import com.training.ToDoApp_Api.ToDoApp.Entity.Task;

import java.util.List;

public interface ITaskService {

    List<Task> getAllTasks();

    Task saveTask(Task task);

    Task updateTask(Task task);

    void deleteTask(Long id);

}
