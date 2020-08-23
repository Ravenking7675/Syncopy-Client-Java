package com.avinash.syncopy.model;

import java.util.ArrayList;

public class ConnectionList {

    private ArrayList<Connection> connections;
    private long response;

    @Override
    public String toString() {
        return "ConnectionList{" +
                "connections=" + connections +
                ", response=" + response +
                '}';
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }

    public void setConnections(ArrayList<Connection> connections) {
        this.connections = connections;
    }

    public long getResponse() {
        return response;
    }

    public void setResponse(long response) {
        this.response = response;
    }
}
