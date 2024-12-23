package com.weblog.ui.blog.views;

import java.util.Scanner;

import com.weblog.entity.Blog;

public class ListBlogsView {
    private Scanner scanner;

    public ListBlogsView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String promptForBlogger() {
        System.out.print("Enter the email of the blogger whose blogs you would like to read: ");
        String email = scanner.nextLine();
        System.out.println();
        return email;
    }

    public void displayBlogDetails(Blog blog, String bloggerName) {
        System.out.println("ID: " + blog.getId());
        System.out.println("Title: " + blog.getTitle());
        System.out.println("Body: " + blog.getBody());
        System.out.println("Private: " + blog.getIsPrivate());
        System.out.println("Date: " + blog.getCreatedAt());
        System.out.println("Blogger: " + bloggerName);
        System.out.println();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

