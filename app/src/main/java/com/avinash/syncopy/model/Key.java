package com.avinash.syncopy.model;

public class Key {

    private String UUID;
    private String response;

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Key{" +
                "UUID='" + UUID + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
