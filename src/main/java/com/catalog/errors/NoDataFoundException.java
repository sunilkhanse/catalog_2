package com.catalog.errors;

public class NoDataFoundException extends Exception {

    private String message;

    public NoDataFoundException(String message) {
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
