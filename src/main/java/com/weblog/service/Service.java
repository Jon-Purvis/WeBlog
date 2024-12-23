package com.weblog.service;

import com.weblog.entity.Blog;
import com.weblog.entity.Blogger;
import com.weblog.entity.BloggerProfile;
import com.weblog.service.interfaces.BloggerManager;
import com.weblog.service.interfaces.ReaderManager;
import com.weblog.service.interfaces.BlogManager;

import java.util.List;

public class Service {
    private BloggerManager bloggerManager;
    private BlogManager blogManager;
    private ReaderManager readerManager;

    public Service(BloggerManager bloggerManager, BlogManager blogManager, ReaderManager readerManager) {
        this.bloggerManager = bloggerManager;
        this.blogManager = blogManager;
        this.readerManager = readerManager;
    }

    // Start of BloggerManager methods //
    public BloggerProfile registerBlogger(Blogger blogger) {
        return bloggerManager.registerBlogger(blogger); 
    }


    public BloggerProfile validateLogin(String email, String plainPassword) {
        return bloggerManager.validateLogin(email, plainPassword);
    }

    public Blogger getBloggerByEmail(String email) {
        return bloggerManager.getBloggerByEmail(email);
    }

    public List<Blogger> getAllBloggers() {
        return bloggerManager.getAllBloggers();
    }


    // Start of BlogManager methods //
    public Blog postBlog(Blog blog) {
        return blogManager.postBlog(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogManager.getAllBlogs();
    }

    public List<Blog> getAllBlogsOfBlogger(String email, BloggerProfile sessionData) {
        return blogManager.getAllBlogsOfBlogger(email, sessionData);
    }


    //Start of ReaderManager methods //
    public List<String> addReaders(String userEmail, List<String> readerEmailList) {
        return readerManager.addReaders(userEmail, readerEmailList);
    }
}