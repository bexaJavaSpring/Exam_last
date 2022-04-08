package com.example.exam_last.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private String name;
    private Double price;
    private Double amount;
    private Integer categoryId;
}
