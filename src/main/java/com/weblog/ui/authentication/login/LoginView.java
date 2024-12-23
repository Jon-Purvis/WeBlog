package com.weblog.ui.authentication.login;

import java.util.Scanner;

public class LoginView {
    private Scanner scanner;

    public LoginView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getEmail() {
        System.out.println();
        System.out.print("Enter your email: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        System.out.println();
        return password;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public boolean askRetry() {
        System.out.print("Would you like to try again? (yes/no): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("yes");
    }
}