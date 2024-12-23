package com.weblog.entity;

import java.util.List;

public class Blogger {
    private String email;
    private String password;
    private String name;
    private String address;
    private List<String> interests; 
    

    public Blogger() {}

    public Blogger(String email, String password, String name, String address, List<String> interests) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.interests = interests;

    }

    @Override
    public String toString() {
        return "Blogger{email='" + email + "', name='" + name + "', address='" + address + "'}";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }
}
