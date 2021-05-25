package com.catalog.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductDetails implements Serializable {

    private static final long serialVersionUID = -2990756534214515602L;

    private Integer productId;
    private String productName;
    private Integer categoryId;
    private String categoryName;
    private List<Attribute> attributes = new ArrayList<>();

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
