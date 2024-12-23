package com.weblog.ui.authentication.register;

import java.util.Scanner;

public class RegistrationView {
    private Scanner scanner;

    public RegistrationView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getEmail() {
        System.out.println();
        System.out.print("Enter your email: ");
        return scanner.nextLine();
    }

    public String getPassword() {
        System.out.print("Enter your password: ");
        return scanner.nextLine();
    }

    public String getName() {
        System.out.print("Enter your name: ");
        return scanner.nextLine();
    }

    public String getAddress() {
        System.out.print("Enter your address: ");
        return scanner.nextLine();
    }

    public String getInterest() {
        System.out.print("> ");
        String interest = scanner.nextLine();
        return interest;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public boolean askRetry() {
        System.out.print("Would you like to try again with a different email? (yes to retry, no to return to the login/registration menu): ");
        String choice = scanner.nextLine().trim().toLowerCase();
        return choice.equals("yes");
    }

}