package com.training.ToDoApp_Api.ToDoApp.Repository;

import com.training.ToDoApp_Api.ToDoApp.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
}
