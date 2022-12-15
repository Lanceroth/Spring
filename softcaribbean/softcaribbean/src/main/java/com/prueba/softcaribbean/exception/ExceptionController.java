package com.prueba.softcaribbean.exception;

public class ExceptionController extends Exception{

    public ExceptionController() {
    }

    public ExceptionController(String message) {
        super(message);
    }

    public ExceptionController(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionController(Throwable cause) {
        super(cause);
    }

    public ExceptionController(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
