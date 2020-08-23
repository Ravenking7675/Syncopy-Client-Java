package com.avinash.syncopy.model;

public class Connection {

    private String username;
    private String uuid;
    private Boolean isPc;

    @Override
    public String toString() {
        return "Connection{" +
                "username='" + username + '\'' +
                ", uuid='" + uuid + '\'' +
                ", isPc=" + isPc +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getPc() {
        return isPc;
    }

    public void setPc(Boolean pc) {
        isPc = pc;
    }
}
