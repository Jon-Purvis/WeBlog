package com.weblog.ui.authentication;

import java.util.Scanner;

import com.weblog.entity.BloggerProfile;
import com.weblog.service.Service;
import com.weblog.ui.authentication.login.LoginPresenter;
import com.weblog.ui.authentication.register.RegistrationPresenter;


public class AuthenticationPresenter {
    private AuthenticationView authenticationView;
    private Service service;
    private Scanner scanner;

    private LoginPresenter loginPresenter;
    private RegistrationPresenter registrationPresenter;

    public AuthenticationPresenter(Service service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
        this.authenticationView = new AuthenticationView(scanner); 
    }

    public BloggerProfile begin() {
        boolean terminate = false;
        BloggerProfile sanitizedBlogger = null;

        while (!terminate) {
            authenticationView.displayAuthenticationMenu(); 
            int choice = getValidUserChoice(); 

            switch (choice) {
                case 1:  
                    sanitizedBlogger = getLoginPresenter().begin();
                    if (sanitizedBlogger != null) {
                        terminate = true;  
                    }
                    break;
                case 2:  
                    sanitizedBlogger = getRegistrationPresenter().begin();  
                    if (sanitizedBlogger != null) {
                        terminate = true;
                    }
                    break;
                case 3:  
                    terminate = true;  
                    break;
            }
        }
        // Return the BloggerProfile if logged in, or null if quit
        return sanitizedBlogger;
    }


    private int getValidUserChoice() {
        int choice;
        while (true) {
            try {
                choice = authenticationView.getUserChoice();
                if (choice >= 1 && choice <= 3) {
                    break;
                } else {
                    authenticationView.displayMessage("\nInvalid input! Please enter a number between 1 and 3.\n");
                }
            } catch (Exception e) {
                authenticationView.displayMessage("\nInvalid input! Please enter a number between 1 and 3.\n");
                // Clear the invalid input
                scanner.nextLine(); 
            }
        }
        return choice;
    }


    // Lazy load the presenters
    private LoginPresenter getLoginPresenter() {
        if (loginPresenter == null) {
            loginPresenter = new LoginPresenter(service, scanner); 
        }
        return loginPresenter;
    }

    private RegistrationPresenter getRegistrationPresenter() {
        if (registrationPresenter == null) {
            registrationPresenter = new RegistrationPresenter(service, scanner); 
        }
        return registrationPresenter;
    }
}