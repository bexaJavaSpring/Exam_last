package com.example.exam_last.controller;

import com.example.exam_last.dto.ApiResponse;
import com.example.exam_last.dto.CategoryDto;
import com.example.exam_last.repository.CategoryRepository;
import com.example.exam_last.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/category")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    final CategoryRepository categoryRepository;
    final CategoryService categoryService;

    @GetMapping
    public HttpEntity<?> getAll(){
       return ResponseEntity.ok().body(categoryRepository.findAll());
    }
    @PostMapping("/add")
    public HttpEntity<?> add(@Valid @RequestBody CategoryDto dto){
        ApiResponse apiResponse=categoryService.add(dto);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@Valid @RequestBody CategoryDto dto){
        ApiResponse apiResponse=categoryService.edit(id,dto);
        return ResponseEntity.status(apiResponse.isSuccess()?200:409).body(apiResponse);
    }
    @DeleteMapping("/{id}")
    public HttpEntity<?> delete(@PathVariable Integer id){
        ApiResponse apiResponse=categoryService.delete(id);
        return ResponseEntity.status(apiResponse.isSuccess()?204:404).body(apiResponse);
    }
}
