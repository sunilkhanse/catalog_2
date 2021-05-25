package com.catalog.service;

import com.catalog.domain.Product;
import com.catalog.dto.NewProductResponse;
import com.catalog.dto.ProductInput;
import com.catalog.errors.NoDataFoundException;
import com.catalog.response.ProductDetails;

public interface ProductService {

    public ProductDetails getProductDetails(Integer productId) throws NoDataFoundException;

    public Product findById(Integer productId) throws NoDataFoundException;

    public NewProductResponse createProduct(ProductInput product, Integer categoryId);
}
