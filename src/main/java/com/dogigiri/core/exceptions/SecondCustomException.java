package com.dogigiri.core.exceptions;

public class SecondCustomException extends Exception{
    public SecondCustomException() {
        super("secondCustomException");
    }
    public SecondCustomException(Exception e) {
        super(e);
    }
}
