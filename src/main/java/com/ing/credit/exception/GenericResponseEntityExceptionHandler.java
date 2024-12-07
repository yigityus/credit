package com.ing.credit.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public class GenericResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<Error> handle(MethodArgumentNotValidException exception) {
        Error error = new Error(exception.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.of(Optional.of(error));
    }
    @ExceptionHandler
    public ResponseEntity<Error> handle(HttpMessageNotReadableException exception) {
        Error error = new Error(exception.getMessage(), HttpStatus.BAD_REQUEST);
        return ResponseEntity.of(Optional.of(error));
    }

    record Error(String message, HttpStatus status){}
}
