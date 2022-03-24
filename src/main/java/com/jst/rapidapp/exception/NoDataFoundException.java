package com.jst.rapidapp.exception;

public class NoDataFoundException extends  RuntimeException {

    public NoDataFoundException(String message) {
        super(message);
    }

    public NoDataFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
