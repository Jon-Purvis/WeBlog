package com.weblog.database;

import com.weblog.database.interfaces.BloggerDao;
import com.weblog.database.interfaces.ReaderDao;

import java.util.List;

import com.weblog.database.interfaces.BlogDao;
import com.weblog.entity.Blogger;
import com.weblog.entity.Blog;

public class Repository {
    private BloggerDao bloggerDao;
    private BlogDao blogDao;
    private ReaderDao readerDao;

    public Repository(BloggerDao bloggerDao, BlogDao blogDao, ReaderDao readerDao) {
        this.bloggerDao = bloggerDao;
        this.blogDao = blogDao;
        this.readerDao = readerDao;
    }

    // Start of bloggerDao methods //
    public Blogger registerBlogger(Blogger blogger) {
        return bloggerDao.registerBlogger(blogger);
    }

    public List<Blogger> getAllBloggers() {
        return bloggerDao.getAllBloggers();
    }

    public Blogger getBloggerByEmail(String email) {
        return bloggerDao.getBloggerByEmail(email);
    }

    // Start of blogDao methods //
    public Blog postBlog(Blog blog) {
        return blogDao.postBlog(blog);
    }

    public List<Blog> getAllBlogs() {
        return blogDao.getAllBlogs();
    }

    public List<Blog> getAllBlogsOfBlogger(String email) {
        return blogDao.getAllBlogsOfBlogger(email);
    }

    public List<Blog> getPublicBlogsOfBlogger(String email) {
        return blogDao.getPublicBlogsOfBlogger(email);
    }

    // Start of ReaderDao methods //
    public List<String> addReaders(String userEmail,List<String> readerEmailList) {
        return readerDao.addReaders(userEmail, readerEmailList);
    }

    public Boolean isReaderOfBlogger(String reader, String blogger) {
        return readerDao.isReaderOfBlogger(reader, blogger);
    }
}
