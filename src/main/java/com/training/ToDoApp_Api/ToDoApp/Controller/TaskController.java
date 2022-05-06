package com.training.ToDoApp_Api.ToDoApp.Controller;


import com.training.ToDoApp_Api.ToDoApp.Entity.Task;
import com.training.ToDoApp_Api.ToDoApp.Service.Interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class TaskController {

    @Autowired
    ITaskService taskService;

    @GetMapping("get/tasks")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @PostMapping("create/task")
    public Task createTask(@RequestBody Task task){
        return taskService.saveTask(task);
    }

    @PutMapping("update/task")
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("delete/task")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
