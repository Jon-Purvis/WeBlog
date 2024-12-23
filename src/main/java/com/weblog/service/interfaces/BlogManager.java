package com.weblog.service.interfaces;

import java.util.List;

import com.weblog.entity.Blog;
import com.weblog.entity.BloggerProfile;

public interface BlogManager {
    Blog postBlog(Blog blog);
    List<Blog> getAllBlogs();
    List<Blog> getAllBlogsOfBlogger(String email, BloggerProfile sessionData);
}
