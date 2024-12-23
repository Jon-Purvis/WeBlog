package com.weblog.ui;

import java.util.Scanner;

public class MainView {
    private Scanner scanner;

    public MainView(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMainMenu() {
        System.out.println("--- Main Menu ---");
        System.out.println("1: List all bloggers");
        System.out.println("2: Post a blog");
        System.out.println("3: List all blogs");
        System.out.println("4: Choose bloggers that can read your private posts");
        System.out.println("5: Read blogs of a specific blogger");
        System.out.println("6: Exit");
    }

    public int getUserChoice() {
        System.out.print("Please make a selection (1-6): ");
        int choice = scanner.nextInt();
        // clear newline in buffer
        scanner.nextLine();
        System.out.println();

        return choice;
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}