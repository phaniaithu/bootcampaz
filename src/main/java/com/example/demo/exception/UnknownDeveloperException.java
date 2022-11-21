package com.example.demo.exception;

public class UnknownDeveloperException extends Exception {
    public UnknownDeveloperException(String message) {
        super(message);
    }

    public UnknownDeveloperException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownDeveloperException(Throwable cause) {
        super(cause);
    }
}
