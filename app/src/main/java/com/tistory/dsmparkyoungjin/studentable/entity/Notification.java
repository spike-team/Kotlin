package com.tistory.dsmparkyoungjin.studentable.entity;

public class Notification {

    private String date;

    private String content;

    public Notification(String date, String content) {
        this.date = date;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
