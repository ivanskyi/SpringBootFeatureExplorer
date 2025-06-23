package com.ivanskyi.sbfe.exception.api;

import org.springframework.http.HttpStatus;

public class InvalidPageNumberException extends ApiException {

    public InvalidPageNumberException(String message) {
        super("Invalid page number. Page number: " + message, HttpStatus.BAD_REQUEST);
    }
}
