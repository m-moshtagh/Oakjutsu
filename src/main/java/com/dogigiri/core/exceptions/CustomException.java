package com.dogigiri.core.exceptions;

public class CustomException extends Exception {
    public CustomException() {
        super("Caused by CustomException");
    }

    public CustomException(String message) {
        super(message);
    }

}
