package com.catalog.dto;

import java.io.Serializable;

public class CreateProductCategoryResponseDto implements Serializable {

    private Integer categoryId;

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
