package com.example.exam_last.repository;

import com.example.exam_last.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    boolean existsByName(String name);
}
