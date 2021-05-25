package com.catalog.errors;

public class DuplicateCategoryException extends Exception {

    private String message;

    public DuplicateCategoryException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
