package com.ruaco.tinyweb.exception;

public class ControllerException extends RuntimeException {

    private Integer statusCode;

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }
}
