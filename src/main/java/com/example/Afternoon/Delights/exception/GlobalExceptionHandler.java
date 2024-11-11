package com.example.Afternoon.Delights.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle PinAlreadyExistsException
    @ExceptionHandler(PinAlreadyExistsException.class)
    public ResponseEntity<String> handlePinAlreadyExistsException(PinAlreadyExistsException ex) {
        // Return the message in the response body with HTTP 400 (Bad Request)
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
