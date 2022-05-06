package com.training.ToDoApp_Api.ToDoApp.Repository;

import com.training.ToDoApp_Api.ToDoApp.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
