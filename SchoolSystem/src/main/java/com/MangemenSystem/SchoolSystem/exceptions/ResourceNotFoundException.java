package com.MangemenSystem.SchoolSystem.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource Not Found Exception");
    }
    public ResourceNotFoundException(String customMessage) {

        super(customMessage);
    }

}
