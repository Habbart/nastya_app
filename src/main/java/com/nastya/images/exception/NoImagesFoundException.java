package com.nastya.images.exception;

public class NoImagesFoundException extends RuntimeException{

    public NoImagesFoundException(String message) {
        super(message);
    }

    public NoImagesFoundException(Throwable cause) {
        super(cause);
    }
}
