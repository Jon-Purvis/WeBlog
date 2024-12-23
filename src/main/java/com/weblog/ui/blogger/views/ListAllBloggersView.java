package com.weblog.ui.blogger.views;

import com.weblog.entity.Blogger;

public class ListAllBloggersView {
    
    public void displayHeader() {
        System.out.printf("%-40s %-30s %-50s\n", "Email", "Name", "Address"); 
        System.out.println("------------------------------------------------------------" +
                           "------------------------------------------------------------");
    }
    
    public void displayBloggerDetails(Blogger blogger) {
        System.out.printf("%-40s %-30s %-50s\n", blogger.getEmail(), blogger.getName(), blogger.getAddress());
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
