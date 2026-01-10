package com.bridgelabz.flipkey;

import java.util.Scanner;

public class Program {

    public static String CleanseAndInvert(String input) {

        // Null or length check
        if (input == null || input.length() < 6) {
            return "";
        }

        // Check for space, digit, or special character
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (!Character.isLetter(ch)) {
                return "";
            }
        }

        // Convert to lowercase
        input = input.toLowerCase();

        StringBuilder filtered = new StringBuilder();

        // Remove characters with even ASCII values
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch % 2 != 0) {   // odd ASCII values
                filtered.append(ch);
            }
        }

        // Reverse remaining characters
        filtered.reverse();

        // Convert even-positioned characters to uppercase
        for (int i = 0; i < filtered.length(); i++) {
            if (i % 2 == 0) {
                filtered.setCharAt(i, Character.toUpperCase(filtered.charAt(i)));
            }
        }

        return filtered.toString();
    }

    // Main method
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the word");
        String input = scanner.nextLine();

        String result = CleanseAndInvert(input);

        if (result.isEmpty()) {
            System.out.println("Invalid Input");
        } else {
            System.out.println("The generated key is - " + result);
        }
        
        scanner.close();
    }
}
