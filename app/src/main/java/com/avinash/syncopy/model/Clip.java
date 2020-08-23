package com.avinash.syncopy.model;

public class Clip {

    private String sender;
    private String sender_id;
    private String reciever;
    private String reciever_id;
    private String time;
    private String content;
    private Boolean checked;


    public Clip() {
    }



    public Clip(String sender, String reciever, String sender_id, String reciever_id, String content, Boolean checked, String time) {
        this.sender = sender;
        this.reciever = reciever;
        this.sender_id = sender_id;
        this.reciever_id = reciever_id;
        this.content = content;
        this.checked = checked;
        this.time = time;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReciever() {
        return reciever;
    }

    public void setReciever(String reciever) {
        this.reciever = reciever;
    }

    public String getSender_id() {
        return sender_id;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }

    public String getReciever_id() {
        return reciever_id;
    }

    public void setReciever_id(String reciever_id) {
        this.reciever_id = reciever_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Clip{" +
                "sender='" + sender + '\'' +
                ", reciever='" + reciever + '\'' +
                ", sender_id='" + sender_id + '\'' +
                ", reciever_id='" + reciever_id + '\'' +
                ", content='" + content + '\'' +
                ", checked=" + checked +
                ", time=" + time +
                '}';
    }
}
