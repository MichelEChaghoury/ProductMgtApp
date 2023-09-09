package com.ultims.productmgt.queryservice.shared.exception;

public class DuplicateFoundException extends RuntimeException {

    public DuplicateFoundException(String message) {
        super(message);
    }
}
