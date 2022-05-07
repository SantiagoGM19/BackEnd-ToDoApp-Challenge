package com.training.ToDoApp_Api.ToDoApp.Controller;


import com.training.ToDoApp_Api.ToDoApp.DTO.TaskDTO;
import com.training.ToDoApp_Api.ToDoApp.Entity.Task;
import com.training.ToDoApp_Api.ToDoApp.Service.Interfaces.ITaskService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class TaskController {

    @Autowired
    ITaskService taskService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("get/tasks")
    public List<TaskDTO> getAllTasks(){
        List<Task> tasks = taskService.getAllTasks();
        return tasks.stream().map(task -> modelMapper.map(task, TaskDTO.class)).collect(Collectors.toList());

    }

    @PostMapping("create/task")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO){
        Task task = modelMapper.map(taskDTO, Task.class);
        Task taskSaved = taskService.saveTask(task);
        if(taskSaved != null){
            TaskDTO taskDTOResponse = modelMapper.map(taskSaved, TaskDTO.class);
            return new ResponseEntity<>(taskDTOResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("update/task")
    public ResponseEntity<TaskDTO> updateTask(@RequestBody TaskDTO taskDTO){
        Task task = modelMapper.map(taskDTO, Task.class);
        Task taskSaved = taskService.updateTask(task);
        if(taskSaved != null){
            TaskDTO taskDTOResponse = modelMapper.map(taskSaved, TaskDTO.class);
            return new ResponseEntity<>(taskDTOResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("delete/task/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }
}
