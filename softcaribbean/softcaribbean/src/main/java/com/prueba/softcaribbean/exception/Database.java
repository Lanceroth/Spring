package com.prueba.softcaribbean.exception;

public class Database extends Exception{
    public Database() {
    }

    public Database(String message) {
        super(message);
    }

    public Database(String message, Throwable cause) {
        super(message, cause);
    }

    public Database(Throwable cause) {
        super(cause);
    }

    public Database(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
