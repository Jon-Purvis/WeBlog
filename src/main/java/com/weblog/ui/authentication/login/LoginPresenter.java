package com.weblog.ui.authentication.login;

import com.weblog.entity.BloggerProfile;
import com.weblog.service.Service;

import java.util.Scanner;

public class LoginPresenter {
    private Service service;
    private LoginView loginView;

    public LoginPresenter(Service service, Scanner scanner) {
        this.service = service;
        this.loginView = new LoginView(scanner);
    }

    public BloggerProfile begin() {
        while (true) {
            String email = loginView.getEmail();
            String password = loginView.getPassword();
            BloggerProfile bloggerProfile = service.validateLogin(email, password);

            if (bloggerProfile != null) {
                return bloggerProfile;
            } else {
                loginView.displayMessage("Invalid email or password.");
                
                if (!loginView.askRetry()) {
                    return null; 
                }
            }
        }
    }
}