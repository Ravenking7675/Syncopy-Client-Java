package com.avinash.syncopy.model;

public class ClipPUT {

    private Clip clip;
    private int response;

    @Override
    public String toString() {
        return "ClipPUT{" +
                "clip=" + clip +
                ", response=" + response +
                '}';
    }

    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }
}
