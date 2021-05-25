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
 * Category attribute controller
 * */
@RestController
@RequestMapping("/categories")
public class CategoryAttributeController {

    @Autowired
    @Qualifier("CategoryAttributeServiceImpl")
    private AttributeService attributeService;

    /**
     * Create category attributes
     * */
    @PostMapping("/{category_id}/attributes")
    public void createAndSaveAttributes(@PathVariable(name = "category_id") Integer categoryId, @RequestBody List<AttributeInputDto> attributes) throws NoDataFoundException {
        attributeService.createAndAssignAttributes(attributes, categoryId);
    }

    /**
     * Get category attributes using category id
     * */
    @GetMapping("/{category_id}/attributes")
    public ResponseEntity<List<Attribute>> getCategoryAttributes(@PathVariable(name = "category_id") Integer categoryId) throws NoDataFoundException {
        List<Attribute> attributes = attributeService.getAttributes(categoryId);
        return ResponseEntity.ok(attributes);
    }
}
