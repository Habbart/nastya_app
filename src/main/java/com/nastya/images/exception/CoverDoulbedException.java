package com.nastya.images.exception;

public class CoverDoulbedException extends RuntimeException {

    public CoverDoulbedException(String message) {
        super(message);
    }

    public CoverDoulbedException(Throwable cause) {
        super(cause);
    }
}
