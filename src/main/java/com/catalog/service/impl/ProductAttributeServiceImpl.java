package com.catalog.service.impl;

import com.catalog.domain.Product;
import com.catalog.domain.ProductAttribute;
import com.catalog.domain.ProductCategory;
import com.catalog.dto.AttributeInputDto;
import com.catalog.errors.NoDataFoundException;
import com.catalog.repository.AttributeRepository;
import com.catalog.response.Attribute;
import com.catalog.service.AttributeService;
import com.catalog.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "ProductAttributeServiceImpl")
public class ProductAttributeServiceImpl implements AttributeService {

    @Autowired
    private ProductService productService;

    @Autowired
    private AttributeRepository attributeRepository;

    @Override
    public void createAndAssignAttributes(List<AttributeInputDto> attributes, Integer productId) throws NoDataFoundException {
        buildAttributes(attributes, productId);
    }

    private void buildAttributes(List<AttributeInputDto> attributes, Integer productId) throws NoDataFoundException {
        Product product = productService.findById(productId);
        List<ProductAttribute> attributeList = new ArrayList<>();
        attributes
                .forEach(input -> {
                    ProductAttribute attribute = new ProductAttribute();
                    attribute.setProduct(product);
                    attribute.setName(input.getName());
                    attribute.setValue(input.getValue());
                    attributeList.add(attribute);
                });
        attributeRepository.saveAll(attributeList);
    }

    @Override
    public List<Attribute> getAttributes(Integer id) throws NoDataFoundException {
        Product product = productService.findById(id);
        if (product.getAttributes().isEmpty()) {
            throw new NoDataFoundException("No attributes found for product id ".concat(id.toString()));
        }
        List<Attribute> attributes = new ArrayList<>();
        product.getAttributes()
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
