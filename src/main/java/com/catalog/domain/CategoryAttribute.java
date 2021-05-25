package com.catalog.domain;

import javax.persistence.*;

@Entity
@Table(name = "category_attribute")
public class CategoryAttribute extends Attribute {

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
