package com.weblog.entity;

public class Reader {
    private String bloggerEmail;
    private String followerEmail;
    

    public Reader () {}

    public Reader(String bloggerEmail, String followerEmail) {
        this.bloggerEmail = bloggerEmail;
        this.followerEmail = followerEmail;
    }

    public String getBloggerEmail() {
        return bloggerEmail;
    }

    public void setBloggerEmail(String bloggerEmail) {
        this.bloggerEmail = bloggerEmail;
    }

    public String getFollowerEmail() {
        return followerEmail;
    }

    public void setFollowerEmail(String followerEmail) {
        this.followerEmail = followerEmail;
    }
    

}
