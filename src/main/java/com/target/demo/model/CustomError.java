package com.target.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by rohit on 6/16/17.
 */
public class CustomError {

    @JsonProperty("ERROR_CODE")
    private String errorCode;
    private String message;

    public CustomError() {
    }

    public CustomError(String errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
