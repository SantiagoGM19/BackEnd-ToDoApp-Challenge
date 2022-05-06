package com.training.ToDoApp_Api.ToDoApp.Service.Interfaces;

import com.training.ToDoApp_Api.ToDoApp.Entity.Category;
import com.training.ToDoApp_Api.ToDoApp.Entity.Task;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategories();

    Category saveCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Long id);

}
