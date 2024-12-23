package com.weblog.ui.blog;

import java.util.List;
import java.util.Scanner;

import com.weblog.entity.Blog;
import com.weblog.service.Service;
import com.weblog.ui.blog.views.ListBlogsView;;

public class ListAllBlogsPresenter {
    private Service service;
    private ListBlogsView view;

    public ListAllBlogsPresenter(Service service, Scanner scanner) {
        this.service = service;
        this.view = new ListBlogsView(scanner);
    }

    public void begin() {
        List<Blog> blogs = service.getAllBlogs();
        
        if (blogs.isEmpty()) {
            view.displayMessage("No blogs posted.\n");
            return;
        }
        
        for (Blog blog : blogs) {
            String bloggerName = service.getBloggerByEmail(blog.getEmail()).getName();
            view.displayBlogDetails(blog, bloggerName);
        }
    }
}
