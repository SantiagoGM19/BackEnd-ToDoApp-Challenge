package com.training.ToDoApp_Api.ToDoApp.Service.Implementation;

import com.training.ToDoApp_Api.ToDoApp.Entity.Category;
import com.training.ToDoApp_Api.ToDoApp.Entity.Task;
import com.training.ToDoApp_Api.ToDoApp.Repository.CategoryRepository;
import com.training.ToDoApp_Api.ToDoApp.Repository.TaskRepository;
import com.training.ToDoApp_Api.ToDoApp.Service.Interfaces.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    TaskRepository taskRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Boolean deleteCategory(Long id) {
        Optional<Category> categoryFound = categoryRepository.findById(id);
        if(categoryFound.isPresent()){
            Category category = categoryFound.get();
            List<Task> tasks = category.getTasks();
            for(Task task : tasks){
                taskRepository.deleteById(task.getId());
            }
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
