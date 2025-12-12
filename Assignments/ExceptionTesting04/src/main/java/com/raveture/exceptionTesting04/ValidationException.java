package com.raveture.exceptionTesting04;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
