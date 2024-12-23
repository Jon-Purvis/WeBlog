package com.weblog.ui.blog.views;

import java.util.Scanner;

import com.weblog.entity.Blog;

public class PostBlogView {
    private Scanner scanner;

    public PostBlogView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Blog displayBlogForm() {
        Blog blog = new Blog();

        System.out.print("Enter the title of the blog: ");
        blog.setTitle(scanner.nextLine());

        System.out.print("Enter the body of the blog: ");
        blog.setBody(scanner.nextLine());

        return blog;
    }

    public String getBlogPrivacyInput() {
        System.out.print("Is this blog private? (Y/N): ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}