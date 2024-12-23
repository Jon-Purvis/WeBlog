package com.weblog.service.interfaces;

import com.weblog.entity.Blogger;
import com.weblog.entity.BloggerProfile;

import java.util.List;

public interface BloggerManager {
    // Returns BloggerProfile or null
    BloggerProfile registerBlogger(Blogger blogger); 
    BloggerProfile validateLogin(String email, String plainPassword);
    List<Blogger> getAllBloggers();
    Blogger getBloggerByEmail(String email);
}