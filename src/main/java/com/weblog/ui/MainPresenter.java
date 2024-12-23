package com.weblog.ui;

import java.util.Scanner;
import com.weblog.entity.BloggerProfile;
import com.weblog.service.Service;
import com.weblog.ui.blogger.ListAllBloggersPresenter;
import com.weblog.ui.reader.AddReadersPresenter;
import com.weblog.ui.blog.PostBlogPresenter;
import com.weblog.ui.blog.ReadBloggersBlogsPresenter;
import com.weblog.ui.blog.ListAllBlogsPresenter;

public class MainPresenter {
    private MainView mainView;
    private Service service;
    private BloggerProfile sessionData;
    private Scanner scanner;

    private ListAllBloggersPresenter listAllBloggersPresenter;
    private PostBlogPresenter postBlogPresenter;
    private ListAllBlogsPresenter listAllBlogsPresenter;
    private AddReadersPresenter addReadersPresenter;
    private ReadBloggersBlogsPresenter readBloggersBlogsPresenter;

    public MainPresenter(Service service, BloggerProfile sessionData, Scanner scanner) {
        this.service = service;
        this.sessionData = sessionData;
        this.scanner = scanner;
        this.mainView = new MainView(scanner);
    }

    public void begin() {
        boolean terminate = false;

        String welcomeMessage = "--- Welcome to WeBlog, " + sessionData.getName() + "! ---\n";
        mainView.displayMessage(welcomeMessage); 

        while (!terminate) {
            mainView.displayMainMenu();
            int choice = getValidUserChoice();

            switch (choice) {
                case 1:
                    getListAllBloggersPresenter().begin();
                    break;
                case 2:
                    getPostBlogPresenter().begin();
                    break;
                case 3:
                    getListAllBlogsPresenter().begin();
                    break;
                case 4:
                    getAddReadersPresenter().begin();
                    break;
                case 5:
                    getReadBloggersBlogsPresenter().begin();
                    break;
                case 6:
                    terminate = true;
                    mainView.displayMessage("Exiting the application.");
                    break;
                default:
                    mainView.displayMessage("Invalid choice, please try again.");
            }
        }
    }

    private int getValidUserChoice() {
        int choice;
        while (true) {
            try {
                choice = mainView.getUserChoice();
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    mainView.displayMessage("Invalid input! Please enter a number between 1 and 6.");
                }
            } catch (Exception e) {
                mainView.displayMessage("Invalid input! Please enter a number between 1 and 6.");
                // Clear the invalid input
                scanner.nextLine(); 
            }
        }
        return choice;
    }

    // Lazy load the presenters
    private ListAllBloggersPresenter getListAllBloggersPresenter() {
        if (listAllBloggersPresenter == null) {
            listAllBloggersPresenter = new ListAllBloggersPresenter(service);
        }
        return listAllBloggersPresenter;
    }

    private PostBlogPresenter getPostBlogPresenter() {
        if (postBlogPresenter == null) {
            postBlogPresenter = new PostBlogPresenter(service, sessionData, scanner);
        }
        return postBlogPresenter;
    }

    private ListAllBlogsPresenter getListAllBlogsPresenter() {
        if (listAllBlogsPresenter == null) {
            listAllBlogsPresenter = new ListAllBlogsPresenter(service, scanner);
        }
        return listAllBlogsPresenter;
    }

    private AddReadersPresenter getAddReadersPresenter() {
        if (addReadersPresenter == null) {
            addReadersPresenter = new AddReadersPresenter(service, sessionData, scanner);
        }
        return addReadersPresenter;
    }

    private ReadBloggersBlogsPresenter getReadBloggersBlogsPresenter() {
        if (readBloggersBlogsPresenter == null) {
            readBloggersBlogsPresenter = new ReadBloggersBlogsPresenter(service, sessionData, scanner);
        }
        return readBloggersBlogsPresenter;
    }
}