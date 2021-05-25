package com.catalog.handlers.exception;

import com.catalog.errors.DuplicateCategoryException;
import com.catalog.errors.NoDataFoundException;
import com.catalog.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler({DuplicateCategoryException.class})
    public ResponseEntity handleDuplicateCategoryException(Exception ex) {
        APIResponse response = buildResponseEntity(ex);
        ResponseEntity responseEntity = new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        return responseEntity;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler({NoDataFoundException.class})
    public ResponseEntity handleNoDataFoundException(Exception ex) {
        APIResponse response = buildResponseEntity(ex);
        ResponseEntity responseEntity = new ResponseEntity(response, HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    private APIResponse buildResponseEntity(Exception ex) {
        APIResponse response = new APIResponse();
        response.setMessage(ex.getMessage());
        return response;
    }
}
