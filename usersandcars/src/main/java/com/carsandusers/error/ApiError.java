package com.carsandusers.error;

public class ApiError {

    private String message;


    public ApiError(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public ApiError setMessage(String message) {
        this.message = message;
        return this;
    }


}
