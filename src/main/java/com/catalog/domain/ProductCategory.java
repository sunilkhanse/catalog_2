package com.catalog.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Categories")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category", targetEntity = Product.class, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();

    @OneToMany(targetEntity = CategoryAttribute.class, mappedBy = "category")
    private List<CategoryAttribute> attributes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<CategoryAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<CategoryAttribute> attributes) {
        this.attributes = attributes;
    }


}
