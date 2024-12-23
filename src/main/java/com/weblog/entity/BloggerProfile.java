package com.weblog.entity;

import java.util.List;

public class BloggerProfile {
    private String email;
    private String name;
    private List<String> interests; 
    

    public BloggerProfile() {}

    public BloggerProfile(String email, String name, List<String> interests) {
        this.email = email;
        this.name = name;
        this.interests = interests;
    }

    @Override
    public String toString() {
        return "Blogger{email='" + email + "', name='" + name + "'}";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
