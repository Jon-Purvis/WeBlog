package com.weblog.service.implementations;

import java.util.List;

import com.weblog.database.Repository;
import com.weblog.entity.Blog;
import com.weblog.entity.BloggerProfile;
import com.weblog.service.interfaces.BlogManager;

public class BlogManagerImpl implements BlogManager{
    private Repository repository;

    public BlogManagerImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Blog postBlog(Blog blog) {
        return repository.postBlog(blog);
    }

    @Override
    public List<Blog> getAllBlogs() {
        return repository.getAllBlogs();
    }

    @Override
    public List<Blog> getAllBlogsOfBlogger(String email, BloggerProfile sessionData) {
        if (repository.isReaderOfBlogger(sessionData.getEmail(), email)) {
            return repository.getAllBlogsOfBlogger(email);
        } else {
            return repository.getPublicBlogsOfBlogger(email);
        }
    }

    
}
