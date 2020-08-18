package com.deep.msscbeerservice.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class MvcExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity validateErrorHandler(ConstraintViolationException ex){
        List<String> errors = new ArrayList(ex.getConstraintViolations().size());

        ex.getConstraintViolations().forEach( error -> errors.add(error.toString()));

        return new ResponseEntity(errors, HttpStatus.BAD_REQUEST);
    }

}
