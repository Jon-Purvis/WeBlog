package com.weblog.ui.authentication;

import java.util.Scanner;

public class AuthenticationView {
    private Scanner scanner;

    public AuthenticationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayAuthenticationMenu() {
        System.out.println("\nPlease select an option:");
        System.out.println("1: Login");
        System.out.println("2: Register");
        System.out.println("3: Exit");
    }

    public int getUserChoice() {
        System.out.print("Please make a selection (1-3): ");
        int choice = scanner.nextInt();
        // clear newline in buffer
        scanner.nextLine();

        return choice;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}