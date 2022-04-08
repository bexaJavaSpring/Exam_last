package com.example.exam_last.service;

import com.example.exam_last.dto.ApiResponse;
import com.example.exam_last.dto.CategoryDto;
import com.example.exam_last.entity.Category;
import com.example.exam_last.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    final CategoryRepository categoryRepository;

    public ApiResponse add(CategoryDto dto) {
        if (categoryRepository.existsByName(dto.getName())) {
            return new ApiResponse("Already exist",false);
        }
        Category category=new Category();
        category.setName(dto.getName());
        category.setActive(dto.isActive());
        categoryRepository.save(category);
        return new ApiResponse("Added",true);
    }

    public ApiResponse edit(Integer id, CategoryDto dto) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Category category = byId.get();
        category.setName(dto.getName());
        category.setActive(dto.isActive());
        categoryRepository.save(category);
        return new ApiResponse("Edited",true);
    }

    public ApiResponse delete(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        Category category = byId.get();
        categoryRepository.delete(category);
        return new ApiResponse("Deleted",true);
    }
}
