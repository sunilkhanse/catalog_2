package com.catalog.response;

import com.catalog.constant.AttributeType;

import java.io.Serializable;

public class ProductAttribute extends Attribute implements Serializable {

    private static final long serialVersionUID = 5283877058521489557L;

    private final AttributeType attributeType = AttributeType.PRODUCT;

    public AttributeType getAttributeType() {
        return attributeType;
    }
}
