package com.weblog.ui.blog;

import java.util.List;
import java.util.Scanner;

import com.weblog.entity.Blog;
import com.weblog.entity.Blogger;
import com.weblog.entity.BloggerProfile;
import com.weblog.service.Service;
import com.weblog.ui.blog.views.ListBlogsView;
import com.weblog.ui.blogger.views.ListAllBloggersView;

public class ReadBloggersBlogsPresenter {
    private Service service;
    private BloggerProfile sessionData;
    private ListBlogsView blogsView;
    private ListAllBloggersView bloggersView;
    
    public ReadBloggersBlogsPresenter(Service service, BloggerProfile sessionData, Scanner scanner) {
        this.service = service;
        this.sessionData = sessionData;
        this.blogsView = new ListBlogsView(scanner);
        this.bloggersView = new ListAllBloggersView();
    }

    public void begin() {
        listAllBloggers();
        String postersEmail = blogsView.promptForBlogger();

        List<Blog> blogs = service.getAllBlogsOfBlogger(postersEmail, sessionData);

        if (blogs.isEmpty()) {
            blogsView.displayMessage("This blogger hasn't posted any blog yet.\n");
            return;
        }

        for (Blog blog : blogs) {
            String postersName = service.getBloggerByEmail(postersEmail).getName();
            blogsView.displayBlogDetails(blog, postersName);
        }
    }

    private void listAllBloggers() {
        List<Blogger> bloggers = service.getAllBloggers();
        bloggersView.displayHeader();
        for (Blogger blogger : bloggers) {
            bloggersView.displayBloggerDetails(blogger);
        }
        bloggersView.displayMessage("");
    }

}

