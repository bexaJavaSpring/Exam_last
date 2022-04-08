package com.example.exam_last.service;

import com.example.exam_last.dto.ApiResponse;
import com.example.exam_last.dto.ProductDto;
import com.example.exam_last.entity.Category;
import com.example.exam_last.entity.Product;
import com.example.exam_last.repository.CategoryRepository;
import com.example.exam_last.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    final ProductRepository productRepository;
    final CategoryRepository categoryRepository;

    public ApiResponse add(ProductDto dto) {
        if (productRepository.existsByName(dto.getName())) {
            return new ApiResponse("Already exist",false);
        }
        Product product=new Product();
        Optional<Category> byId = categoryRepository.findById(dto.getCategoryId());
        product.setCategory(byId.get());
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAmount(dto.getAmount());
        productRepository.save(product);
        return new ApiResponse("Added",true);
    }

    public ApiResponse edit(Integer id, ProductDto dto) {
        Optional<Product> byId = productRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Not found",false);
        }
        Product product = byId.get();
        product.setName(dto.getName());
        product.setPrice(dto.getPrice());
        product.setAmount(dto.getAmount());
        Optional<Category> byId1 = categoryRepository.findById(dto.getCategoryId());
        product.setCategory(byId1.get());
        productRepository.save(product);
        return new ApiResponse("Edited",true);
    }
}
