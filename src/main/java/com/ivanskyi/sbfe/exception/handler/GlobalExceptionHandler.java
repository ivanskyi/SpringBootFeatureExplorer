package com.ivanskyi.sbfe.exception.handler;

import com.ivanskyi.sbfe.exception.api.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<?> handleApiException(ApiException exception) {
        return ResponseEntity
                .status(exception.getStatus())
                .body(Map.of("error", exception.getMessage(),
                        "status", exception.getStatus().value()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleApiException(Exception exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Unexpected error",
                        "details", exception.getMessage()
                ));
    }
}
