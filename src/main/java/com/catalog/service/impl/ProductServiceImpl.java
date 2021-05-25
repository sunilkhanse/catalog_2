package com.catalog.service.impl;

import com.catalog.domain.Product;
import com.catalog.domain.ProductCategory;
import com.catalog.dto.NewProductResponse;
import com.catalog.dto.ProductInput;
import com.catalog.errors.NoDataFoundException;
import com.catalog.repository.ProductRepository;
import com.catalog.response.Attribute;
import com.catalog.response.ProductDetails;
import com.catalog.service.ProductCategoryService;
import com.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product findById(Integer productId) throws NoDataFoundException {
        Optional<Product> product = productRepository.findById(productId);
        if (!product.isPresent()) {
            throw new NoDataFoundException("No product found with id ".concat(product.toString()));
        }
        return product.get();
    }

    @Override
    public NewProductResponse createProduct(ProductInput product, Integer categoryId) {
        Product newProduct = buildProduct(product, categoryId);
        NewProductResponse response = new NewProductResponse();
        response.setProductId(newProduct.getId());
        return response;
    }

    private Product buildProduct(ProductInput input, Integer categoryId) {
        ProductCategory category = productCategoryService.fetchById(categoryId);
        Product product = new Product();
        product.setName(input.getProductName());
        product.setCategory(category);
        productRepository.save(product);
        return product;
    }

    @Override
    public ProductDetails getProductDetails(Integer productId) throws NoDataFoundException {
        Product product = this.findById(productId);
        ProductDetails productDetails = new ProductDetails();
        productDetails.setProductId(product.getId());
        productDetails.setProductName(product.getName());
        productDetails.setCategoryId(product.getCategory().getId());
        productDetails.setCategoryName(product.getCategory().getName());

        product.getAttributes()
                .forEach(attribute -> {
                    Attribute prodAttribute = new Attribute();
                    prodAttribute.setId(attribute.getId());
                    prodAttribute.setName(attribute.getName());
                    prodAttribute.setValue(attribute.getValue());
                    productDetails.getAttributes().add(prodAttribute);
                });

        product.getCategory()
                .getAttributes()
                .forEach(attribute -> {
                    Attribute prodAttribute = new Attribute();
                    prodAttribute.setId(attribute.getId());
                    prodAttribute.setName(attribute.getName());
                    prodAttribute.setValue(attribute.getValue());
                    productDetails.getAttributes().add(prodAttribute);
                });

        return productDetails;
    }
}
