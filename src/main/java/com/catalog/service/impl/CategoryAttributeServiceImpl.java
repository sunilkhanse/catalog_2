package com.catalog.service.impl;

import com.catalog.domain.CategoryAttribute;
import com.catalog.domain.ProductCategory;
import com.catalog.dto.AttributeInputDto;
import com.catalog.errors.NoDataFoundException;
import com.catalog.repository.AttributeRepository;
import com.catalog.response.Attribute;
import com.catalog.service.AttributeService;
import com.catalog.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "CategoryAttributeServiceImpl")
public class CategoryAttributeServiceImpl implements AttributeService {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private AttributeRepository attributeRepository;

    @Override
    public void createAndAssignAttributes(List<AttributeInputDto> inputDtos, Integer id) {
        ProductCategory productCategory = productCategoryService.fetchById(id);
        List<CategoryAttribute> attributes = new ArrayList<>();
        inputDtos
                .forEach(input -> {
                    CategoryAttribute attribute = new CategoryAttribute();
                    attribute.setName(input.getName());
                    attribute.setValue(input.getValue());
                    attribute.setCategory(productCategory);
                    attributes.add(attribute);
                });
        attributeRepository.saveAll(attributes);
    }

    @Override
    public List<Attribute> getAttributes(Integer id) throws NoDataFoundException {
        ProductCategory productCategory = productCategoryService.fetchById(id);
        if (productCategory.getAttributes().isEmpty()) {
            throw new NoDataFoundException("No attributes found for category id ".concat(id.toString()));
        }
        List<Attribute> attributes = new ArrayList<>();
        productCategory.getAttributes()
                .forEach(attribute -> {
                    Attribute catAttribute = new Attribute();
                    catAttribute.setId(attribute.getId());
                    catAttribute.setName(attribute.getName());
                    catAttribute.setValue(attribute.getValue());
                    attributes.add(catAttribute);
                });
        return attributes;
    }
}
