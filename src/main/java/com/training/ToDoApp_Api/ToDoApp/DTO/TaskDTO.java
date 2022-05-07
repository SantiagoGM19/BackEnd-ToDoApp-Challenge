package com.training.ToDoApp_Api.ToDoApp.DTO;

import lombok.Data;

import java.io.Serializable;

@Data
public class TaskDTO{

    private Long id;

    private String title;

    private Boolean done;

    private Long fkCategory;
}
