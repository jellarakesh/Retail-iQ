package com.example.advice;

import com.example.exception.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleAll(RuntimeException ex) {
        ErrorResponse response = new ErrorResponse();
        response.setHttpStatusCode(500);
        response.setErrormessage(ex.getMessage());
        return ResponseEntity.status(500).body(response);
    }
}