package com.avinash.syncopy.model;

import java.util.ArrayList;

public class ClipList {

    private ArrayList<Clip> clips;
    private long response;

    public ArrayList<Clip> getClips() {
        return clips;
    }

    public void setClips(ArrayList<Clip> clips) {
        this.clips = clips;
    }

    public long getResponse() {
        return response;
    }

    public void setResponse(long response) {
        this.response = response;
    }

    public ClipList() {
    }

    public ClipList(ArrayList<Clip> clipList) {
        this.clips = clipList;
    }

    public ArrayList<Clip> getClipList() {
        return clips;
    }

    public void setClipList(ArrayList<Clip> clipList) {
        this.clips = clipList;
    }

    @Override
    public String toString() {
        return "ClipList{" +
                "clipList=" + clips +
                '}'+"Error code= "+response;
    }
}
