package com.catalog.dto;

import lombok.*;

/**
 * Product category create input dto
 *
 * */

public class ProductCategoryInputDto {

    private String categoryName;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
