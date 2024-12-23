package com.weblog.ui.blog;

import java.util.Scanner;

import com.weblog.entity.Blog;
import com.weblog.entity.BloggerProfile;
import com.weblog.service.Service;
import com.weblog.ui.blog.views.PostBlogView;

public class PostBlogPresenter {
    private final Service service;
    private final BloggerProfile sessionData;
    private final PostBlogView view;

    public PostBlogPresenter(Service service, BloggerProfile sessionData, Scanner scanner) {
        this.service = service;
        this.sessionData = sessionData;
        this.view = new PostBlogView(scanner);
    }

    public void begin() {
        Blog blog = view.displayBlogForm();
        blog.setEmail(sessionData.getEmail());

        boolean isPrivate = getValidBlogPrivacy();
        blog.setIsPrivate(isPrivate);
        Blog postedBlog = service.postBlog(blog);

        if (postedBlog != null) {
            view.displayMessage("\nBlog posted successfully!\n");
        } else {
            view.displayMessage("\nFailed to post the blog. Please try again.\n");
        }
    }

    private boolean getValidBlogPrivacy() {
        String privacyInput;
        boolean isPrivate = false;

        while (true) {
            privacyInput = view.getBlogPrivacyInput(); 

            if (privacyInput.equals("Y")) {
                isPrivate = true;
                break;
            } else if (privacyInput.equals("N")) {
                isPrivate = false;
                break;
            } else {
                view.displayMessage("Invalid input. Please enter 'Y' for private or 'N' for public.");
            }
        }
        return isPrivate;
    }
}