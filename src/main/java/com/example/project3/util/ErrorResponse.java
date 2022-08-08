package com.example.project3.util;

public class ErrorResponse {

    public String message;

    public long timeStamp;

    public ErrorResponse() {
    }

    public ErrorResponse(String message, long timeStamp) {
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
