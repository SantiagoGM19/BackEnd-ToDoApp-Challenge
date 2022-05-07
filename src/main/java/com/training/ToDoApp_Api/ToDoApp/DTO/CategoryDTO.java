package com.training.ToDoApp_Api.ToDoApp.DTO;

import com.training.ToDoApp_Api.ToDoApp.Entity.Task;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO{
    private Long id;
    private String name;
    private List<Task> tasks = new ArrayList<>();
}
