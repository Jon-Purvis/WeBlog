package com.weblog.ui.reader.views;

import java.util.Scanner;

public class AddReadersView {
    private Scanner scanner;

    public AddReadersView(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public String getBlogger() {
        System.out.print("> ");
        return scanner.nextLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
        
}
