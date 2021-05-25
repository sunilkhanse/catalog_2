package com.catalog.controller;

import com.catalog.domain.Product;
import com.catalog.dto.NewProductResponse;
import com.catalog.dto.ProductInput;
import com.catalog.errors.NoDataFoundException;
import com.catalog.response.ProductDetails;
import com.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * A controller to manage products
 * */
@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    /**
     * Create product for a category
     * */
    @PostMapping("/{category_id}")
    public ResponseEntity<NewProductResponse> createProduct(@PathVariable(value = "category_id") Integer categoryId, @RequestBody ProductInput product) {
        NewProductResponse response = productService.createProduct(product, categoryId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductDetails> getProductByProductId(@PathVariable(value = "product_id") Integer productId) throws NoDataFoundException {
        ProductDetails productDetails = productService.getProductDetails(productId);
        return ResponseEntity.ok(productDetails);
    }
}
