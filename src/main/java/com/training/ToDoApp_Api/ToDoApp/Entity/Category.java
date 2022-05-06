package com.training.ToDoApp_Api.ToDoApp.Entity;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Category")
@Table(name = "categories")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<Task> tasks = new ArrayList<>();

    public Category addTask(Task task){
        this.tasks.add(task);
        return this;
    }

}
