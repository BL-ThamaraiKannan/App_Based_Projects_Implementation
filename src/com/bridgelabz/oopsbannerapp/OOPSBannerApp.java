package com.bridgelabz.oopsbannerapp;

/**
* 00PSBannerApp UC6 - Render OOPS as Banner using functions
*
* This use case extends UC5 by implementing a modular approach to generate each
* letter's pattern through dedicated methods. This enhances code reusability and
* maintainability by separating pattern generation logic from the main display logic.
*
* @author Thamarai Kannan
* @version 6.0
*/

public class OOPSBannerApp {
	
	// Method to generate the pattern for the letter 'O'
    public static String[] getOPattern() {
        return new String[]{
        		"   ***   " ,
        		" **   ** " ,
        		"**     **" ,
        		"**     **" ,
        		"**     **" ,
        		" **   ** " ,
        		"   ***   " 
        };
    }

    // Method to generate the pattern for the letter 'P'
    public static String[] getPPattern() {
        return new String[]{
        		"*******  " ,
        		"**     **" ,
        		"**     **" ,
        		"*******  " ,
        		"**       " ,
        		"**       " ,
        		"**       " 
        };
    }

    // Method to generate the pattern for the letter 'S'
    public static String[] getSPattern() {
        return new String[]{
        		"   ***** " ,
        		" **      " ,
        		"**       " ,
        		"  *****  " ,
        		"      ** " ,
        	    " **   ** " ,
        	    "  *****  "
        };
    }

    // Main method to run the banner display
	public static void main(String[] args) {
		
		// Declare String Arrays to hold patterns for each letter
        String[] oPattern = getOPattern();
        String[] pPattern = getPPattern();
        String[] sPattern = getSPattern();

        // Assemble final banner lines
        String[] lines = new String[7];

        for (int i = 0; i < 7; i++) {
            lines[i] = String.join(" ",
                    oPattern[i],
                    oPattern[i],
                    pPattern[i],
                    sPattern[i]);
        }

		// Print banner using enhanced for loop
        for (String line : lines) {
            System.out.println(line);
        }	
        
	}

}