package com.training.ToDoApp_Api.ToDoApp.Service.Implementation;

import com.training.ToDoApp_Api.ToDoApp.Entity.Category;
import com.training.ToDoApp_Api.ToDoApp.Entity.Task;
import com.training.ToDoApp_Api.ToDoApp.Repository.CategoryRepository;
import com.training.ToDoApp_Api.ToDoApp.Repository.TaskRepository;
import com.training.ToDoApp_Api.ToDoApp.Service.Interfaces.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task saveTask(Task task) {
        Optional<Category> category = categoryRepository.findById(task.getFkCategory());
        if(category.isPresent()){
            Category categoryFound = category.get();
            categoryFound.addTask(task);
            categoryRepository.save(categoryFound);
            return taskRepository.save(task);
        }
        return null;
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
