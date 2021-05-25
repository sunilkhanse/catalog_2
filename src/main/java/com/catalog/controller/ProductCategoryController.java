package com.catalog.controller;

import com.catalog.dto.CreateProductCategoryResponseDto;
import com.catalog.dto.ProductCategoryInputDto;
import com.catalog.errors.DuplicateCategoryException;
import com.catalog.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller to manage product categories
 * */
@RestController
@RequestMapping("/categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * Create category resource
     * */
    @PostMapping
    public ResponseEntity<CreateProductCategoryResponseDto> createProductCategory(@RequestBody ProductCategoryInputDto categoryInput) throws DuplicateCategoryException {
        CreateProductCategoryResponseDto category = productCategoryService.createCategory(categoryInput);
        return ResponseEntity.ok(category);
    }
}
