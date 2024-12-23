package com.weblog.ui.authentication.register;

import com.weblog.service.Service;
import com.weblog.entity.Blogger;
import com.weblog.entity.BloggerProfile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationPresenter {
    private Service service;
    private RegistrationView registrationView;

    public RegistrationPresenter(Service service, Scanner scanner) {
        this.service = service;
        this.registrationView = new RegistrationView(scanner);
    }

    public BloggerProfile begin() {
        String email = promptForEmail();
        if (email == null) {
            // user chose to exit registration
            return null; 
        }
        
        String password = registrationView.getPassword();
        String name = registrationView.getName();
        String address = registrationView.getAddress();
        List<String> interests = collectInterests(); 

        Blogger blogger = new Blogger(email, password, name, address, interests);
        BloggerProfile bloggerProfile = service.registerBlogger(blogger);

        // Check if the registration was successful
        if (bloggerProfile != null) {
            registrationView.displayMessage("\nRegistration successful!\n");
            return bloggerProfile;
        } else {
            registrationView.displayMessage("\nRegistration failed, email might already be taken.");
            return null;
        }
    }

    private String promptForEmail() {
        while (true) {
            String email = registrationView.getEmail();
            // check if email is available
            if (service.getBloggerByEmail(email) == null) { 
                return email; 
            }

            registrationView.displayMessage("\nThis email is already taken.");
            if (!registrationView.askRetry()) {
                registrationView.displayMessage("\nExiting registration. Please proceed to login or try again later.");
                // user chose to exit
                return null; 
            }
        }
    }

    private List<String> collectInterests() {
        List<String> interests = new ArrayList<>();
        registrationView.displayMessage("Enter your interests one at a time. Press Enter on a blank line to finish:");
        while (true) {
            String interest = registrationView.getInterest();
            if (interest.isBlank()) {
                break; 
            }
            interests.add(interest.trim());
        }
        return interests;
    }
}