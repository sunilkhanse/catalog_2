package com.catalog.service.impl;

import com.catalog.domain.ProductCategory;
import com.catalog.dto.CreateProductCategoryResponseDto;
import com.catalog.dto.ProductCategoryInputDto;
import com.catalog.errors.DuplicateCategoryException;
import com.catalog.repository.ProductCategoryRepository;
import com.catalog.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory fetchById(Integer id) {
        Optional<ProductCategory> category = this.productCategoryRepository.findById(id);
        if (!category.isPresent()) {
            throw new NullPointerException("No category found with id ".concat(id.toString()));
        }
        return category.get();
    }

    @Override
    public CreateProductCategoryResponseDto createCategory(ProductCategoryInputDto categoryInput) throws DuplicateCategoryException {

        checkIfDuplicateCategory(categoryInput.getCategoryName());

        ProductCategory category = buildProductCategory(categoryInput);

        CreateProductCategoryResponseDto response = new CreateProductCategoryResponseDto();
        response.setCategoryId(category.getId());
        return response;
    }

    private ProductCategory buildProductCategory(ProductCategoryInputDto categoryInput) {
        ProductCategory category = new ProductCategory();
        category.setName(categoryInput.getCategoryName());
        save(category);
        return category;
    }

    private void checkIfDuplicateCategory(String category) throws DuplicateCategoryException {
        boolean isDuplicate = this.productCategoryRepository.existsByName(category);
        if (isDuplicate) {
            throw new DuplicateCategoryException(category.concat(" already exists"));
        }
    }

    @Override
    public void save(ProductCategory category) {
        this.productCategoryRepository.save(category);
    }
}
