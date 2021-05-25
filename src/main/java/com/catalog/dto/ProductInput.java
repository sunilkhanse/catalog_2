package com.catalog.dto;

import com.sun.istack.NotNull;

import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;

public class ProductInput implements Serializable {

    @NotNull
    private String productName;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
