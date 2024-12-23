package com.weblog.database.interfaces;

import java.util.List;
import com.weblog.entity.Blog;

public interface BlogDao {
    Blog postBlog(Blog blog);
    List<Blog> getAllBlogs();
    public List<Blog> getPublicBlogsOfBlogger(String email);
    public List<Blog> getAllBlogsOfBlogger(String email);

}
