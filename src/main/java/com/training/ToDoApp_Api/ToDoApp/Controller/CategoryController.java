package com.training.ToDoApp_Api.ToDoApp.Controller;

import com.training.ToDoApp_Api.ToDoApp.DTO.CategoryDTO;
import com.training.ToDoApp_Api.ToDoApp.Entity.Category;
import com.training.ToDoApp_Api.ToDoApp.Service.Interfaces.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("get/categories")
    public List<CategoryDTO> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return categories.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }

    @PostMapping("create/category")
    public CategoryDTO createCategory(@RequestBody Category category){
        Category categorySaved =  categoryService.saveCategory(category);
        return modelMapper.map(categorySaved, CategoryDTO.class);
    }

    @DeleteMapping("delete/category/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        Boolean deleted =  categoryService.deleteCategory(id);
        if(deleted){
            return new ResponseEntity<>("The category was deleted", HttpStatus.OK);
        }
        return new ResponseEntity<>("An error has occurred while deleting the category", HttpStatus.BAD_REQUEST);
    }

}
