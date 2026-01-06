package com.bridgelabz.oopsbannerapp;

import java.util.HashMap;

/**
 * OOPSBannerApp UC8 – Advanced OOP Concepts Implementation
 *
 * This use case extends UC7 by utilizing advanced Object-Oriented Programming
 * concepts such as the Java Collections Framework to manage character patterns in a more flexible
 * and efficient manner. The application retrieves and displays the "00PS" banner 
 * using a HashMap there by enhancing code organization and modularity.
 *
 * The application retrieves and displays the "OOPS" banner using these mappings.
 *
 * @author Thamarai Kannan
 * @version 8.0
 */
public class OOPSBannerApp {

    /**
     * Creates a HashMap containing ASCII art patterns for supported characters.
     *
     * Each character is mapped to an array of strings where each string
     * represents one line of the character's ASCII art pattern.
     * All patterns are assumed to have the same height.
     *
     * @return a HashMap where keys are characters and values are String arrays
     *         representing ASCII art pattern lines for each character
     */
    public static HashMap<Character, String[]> createCharacterMap() {

        HashMap<Character, String[]> charMap = new HashMap<>();

        // Pattern for 'O'
        charMap.put('O', new String[]{
        		"   ***   " ,
        		" **   ** " ,
        		"**     **" ,
        		"**     **" ,
        		"**     **" ,
        		" **   ** " ,
        		"   ***   " 
        });

        // Pattern for 'P'
        charMap.put('P', new String[]{
        		"*******  " ,
        		"**     **" ,
        		"**     **" ,
        		"*******  " ,
        		"**       " ,
        		"**       " ,
        		"**       " 
        });

        // Pattern for 'S'
        charMap.put('S', new String[]{
        		"   ***** " ,
        		" **      " ,
        		"**       " ,
        		"  *****  " ,
        		"      ** " ,
        	    " **   ** " ,
        	    "  *****  "
        });

        return charMap;
    }
    

    /**
     * Displays a banner message using the provided character map.
     *
     * This method renders the input message as an ASCII art banner by
     * iterating through each line of the character patterns and horizontally
     * concatenating the corresponding line from each character in the message.
     *
     * @param message - the message to display as a banner.Each character must exist as a key in the charMap
     * @param charMap - the HashMap containing character pattern mappings
     */
    public static void displayBanner(String message, HashMap<Character, String[]> charMap) {

        // Determine pattern height (assuming all patterns have equal height)
        int patternHeight = charMap.get('O').length;

        // Loop through each row of the pattern
        for (int line = 0; line < patternHeight; line++) {

            StringBuilder lineBuilder = new StringBuilder();

            // Loop through each character in the message
            for (char ch : message.toCharArray()) {

                String[] pattern = charMap.getOrDefault(ch, charMap.get(' '));
                lineBuilder.append(pattern[line]).append("  ");
            }

            System.out.println(lineBuilder.toString());
       
        
        }
    }

    /**
     * Main method – Entry point of the application.
     *
     * Initializes the character map, defines the message "OOPS",
     * and displays it as an ASCII art banner.
     *
     */
    public static void main(String[] args) {

        // Create character pattern map
        HashMap<Character, String[]> charMap = createCharacterMap();

        // Message to display
        String message = "OOPS";

        // Display the banner
        displayBanner(message, charMap);
    }
}
