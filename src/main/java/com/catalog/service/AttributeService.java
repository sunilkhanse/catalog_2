package com.catalog.service;

import com.catalog.dto.AttributeInputDto;
import com.catalog.errors.NoDataFoundException;
import com.catalog.response.Attribute;

import java.util.List;

public interface AttributeService {

    void createAndAssignAttributes(List<AttributeInputDto> attributes, Integer id) throws NoDataFoundException;

    List<Attribute> getAttributes(Integer id) throws NoDataFoundException;

}