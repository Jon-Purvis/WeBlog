package com.weblog.entity;

import java.time.LocalDateTime;

public class Blog {
    private int id;
    private String title;
    private String body;
    private Boolean isPrivate;
    private LocalDateTime createdAt;
    private String email;


    public Blog() {}

    public Blog(int id, String title, String body, Boolean isPrivate, LocalDateTime createdAt, String email) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.isPrivate = isPrivate;
        this.createdAt = createdAt;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Blog ID: " + id + "\n" +
               "Title: " + title + "\n" +
               "Body: " + body + "\n" +
               "Visibility: " + (isPrivate ? "Public" : "Private") + "\n" +
               "Date/Time: " + createdAt + "\n" +
               "Blogger: " + email + "\n";
    }
 
    public int getId() { 
        return id; 
    }

    public void setId(int id) {
        this.id = id;
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

    public Boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(Boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt; 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
