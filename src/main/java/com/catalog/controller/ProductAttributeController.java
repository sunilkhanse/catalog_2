package com.catalog.controller;

import com.catalog.dto.AttributeInputDto;
import com.catalog.errors.NoDataFoundException;
import com.catalog.response.Attribute;
import com.catalog.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A controller to manage product attributes
 * */
@RestController
@RequestMapping("/products")
public class ProductAttributeController {

    @Autowired
    @Qualifier(value = "ProductAttributeServiceImpl")
    private AttributeService attributeService;

    /**
     * Create attributes for a product
     * */
    @PostMapping("/{product_id}/attributes")
    public void createAttributes(@PathVariable(name = "product_id") Integer productId, @RequestBody List<AttributeInputDto> attributes) throws NoDataFoundException {
        attributeService.createAndAssignAttributes(attributes, productId);
    }

    /**
     * Get product attributes using product id
     * */
    @GetMapping("/{product_id}/attributes")
    public ResponseEntity<List<Attribute>> getCategoryAttributes(@PathVariable(name = "product_id") Integer productId) throws NoDataFoundException {
        List<Attribute> attributes = attributeService.getAttributes(productId);
        return ResponseEntity.ok(attributes);
    }
}
