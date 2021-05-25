package com.catalog.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @OneToMany(targetEntity = ProductAttribute.class, mappedBy = "product", fetch = FetchType.EAGER)
    private List<ProductAttribute> attributes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ProductAttribute> attributes) {
        this.attributes = attributes;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
