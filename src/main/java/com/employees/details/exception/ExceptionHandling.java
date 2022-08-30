package com.employees.details.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = {ApplicationException.class})
    protected ResponseEntity<Object> handleApplicationConflict(ApplicationException applicationException) {
        return new ResponseEntity<>(new ErrorResponse(applicationException), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {DataIntegrityViolationException.class, ConstraintViolationException.class, NoSuchElementException.class})
    protected ResponseEntity<Object> handleHibernateConflict() {
        return new ResponseEntity<>(new ErrorResponse("Database Error" , "Something wrong with the input data. Please provide the proper input."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity<Object> handleConflict(Exception ex) {
        return new ResponseEntity<>(new ErrorResponse("Error" , "Something went wrong with the application. Please check the logs."), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
