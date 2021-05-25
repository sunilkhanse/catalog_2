package com.catalog.service;

import com.catalog.domain.ProductCategory;
import com.catalog.dto.CreateProductCategoryResponseDto;
import com.catalog.dto.ProductCategoryInputDto;
import com.catalog.errors.DuplicateCategoryException;

public interface ProductCategoryService {

    public ProductCategory fetchById(Integer id);

    public void save(ProductCategory productCategory);

    public CreateProductCategoryResponseDto createCategory(ProductCategoryInputDto categoryInput) throws DuplicateCategoryException;
}
