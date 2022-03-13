package com.example.myretrofit2_v2.models.request;

public class ReqPost {

    private int id;
    private String title;
    private String body;
    private int userId;

    public ReqPost(String title, String body, int userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public ReqPost(int id, String title, String body, int userId) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}