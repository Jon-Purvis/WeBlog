package com.weblog.ui.reader;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.weblog.entity.Blogger;
import com.weblog.entity.BloggerProfile;
import com.weblog.service.Service;
import com.weblog.ui.blogger.views.ListAllBloggersView;
import com.weblog.ui.reader.views.AddReadersView;

public class AddReadersPresenter {
    private Service service;
    private BloggerProfile sessionData;
    private ListAllBloggersView listAllBloggersView;
    private AddReadersView addReadersView;

    public AddReadersPresenter(Service service, BloggerProfile sessionData, Scanner scanner) {
        this.service = service;
        this.sessionData = sessionData;
        this.listAllBloggersView = new ListAllBloggersView();
        this.addReadersView = new AddReadersView(scanner);

    }

    public void begin() {
        listAllBloggers();
        addReaders();
    }

    private void listAllBloggers() {
        List<Blogger> bloggers = service.getAllBloggers();
        listAllBloggersView.displayHeader();
        for (Blogger blogger : bloggers) {
            listAllBloggersView.displayBloggerDetails(blogger);
        }
    }

    private void addReaders() {
        List<String> readerEmailList = new ArrayList<>();

        addReadersView.displayMessage("\nEnter reader emails one at a time. Press Enter on a blank line to finish:");
        while (true) {
            String bloggerEmail = addReadersView.getBlogger().trim(); 
            if (bloggerEmail.isBlank()) {
                break;
            }

            if (readerEmailList.contains(bloggerEmail)) { 
                addReadersView.displayMessage("This email is already in the list: " + bloggerEmail);
            } {
                readerEmailList.add(bloggerEmail);
            }
        }

        if (readerEmailList.isEmpty()) {
            addReadersView.displayMessage("No readers were added.");
            return;
        }

        List<String> result = service.addReaders(sessionData.getEmail(), readerEmailList);
        if (result != null) {
            addReadersView.displayMessage("\nReaders added successfully: " + String.join(", ", result) + "\n");
        } else {
            addReadersView.displayMessage("\nFailed to add reader(s).");
            addReadersView.displayMessage("One or more readers could not be added because they are already a reader of yours.");
            addReadersView.displayMessage("Please check and try again.\n");
        }
    }
}
