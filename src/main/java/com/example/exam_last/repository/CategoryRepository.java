package com.example.exam_last.repository;

import com.example.exam_last.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    boolean existsByName(String name);
}
