package com.avinash.syncopy.model;

public class Response {

    private String message;
    private long response;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getResponse() {
        return response;
    }

    public void setResponse(long response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Response{" +
                "message='" + message + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
