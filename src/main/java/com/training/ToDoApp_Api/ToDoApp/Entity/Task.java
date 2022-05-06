package com.training.ToDoApp_Api.ToDoApp.Entity;


import lombok.Data;

import javax.persistence.*;

@Entity(name = "Task")
@Table(name = "tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private Boolean done;

    private Long fkCategory;
}
