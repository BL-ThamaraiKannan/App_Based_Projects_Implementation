package com.bridgelabz.oopsbannerapp;

/**
 * OOPSBannerApp UC7 – Store Character Pattern in a Class
 *
 * This use case extends UC6 by implementing a CharacterPatternMap class to
 * encapsulate character-to-pattern mappings. The application retrieves and
 * displays the "OOPS" banner using these mappings, improving modularity and
 * maintainability.
 *
 * @author Thamarai Kannan
 * @version 7.0
 */

public class OOPSBannerApp {

    /**
     * CharacterPatternMap – Inner static class for storing character-to-pattern mappings.
     * Encapsulates a single character and its corresponding ASCII art pattern.
     * Provides immutable access to character and pattern data through getters.
     */
    static class CharacterPatternMap {

        Character character;

        String[] pattern;

        public CharacterPatternMap(Character character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        
        public Character getCharacter() {
            return character;
        }

        
        public String[] getPattern() {
            return pattern;
        }
    }

 
    // Creates and initializes CharacterPatternMap array for predefined characters.
    // @return - array of CharacterPatternMap objects containing character patterns
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        return new CharacterPatternMap[]{
            new CharacterPatternMap('O', new String[]{
            		"   ***   " ,
            		" **   ** " ,
            		"**     **" ,
            		"**     **" ,
            		"**     **" ,
            		" **   ** " ,
            		"   ***   " 
            }),
            new CharacterPatternMap('P', new String[]{
            		"*******  " ,
            		"**     **" ,
            		"**     **" ,
            		"*******  " ,
            		"**       " ,
            		"**       " ,
            		"**       " 
            }),
            new CharacterPatternMap('S', new String[]{
            		"   ***** " ,
            		" **      " ,
            		"**       " ,
            		"  *****  " ,
            		"      ** " ,
            	    " **   ** " ,
            	    "  *****  "
            })
        };
    }

    
    /**
     * Retrieves the ASCII pattern for a given character.
     *
     * @param ch       - the character to look up
     * @param charMaps - the array of CharacterPatternMap objects
     * @return         - the pattern array for the character, or space pattern if not found
     */
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] charMaps) {

        for (CharacterPatternMap map : charMaps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }

        // Fallback to space pattern
        return getCharacterPattern(' ', charMaps);
    }


    // Prints a message as a banner using ASCII art patterns.
    public static void printMessage(String message, CharacterPatternMap[] charMaps) {

        int patternHeight = 7;

        for (int row = 0; row < patternHeight; row++) {
            StringBuilder line = new StringBuilder();

            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, charMaps);
                line.append(pattern[row]).append("  ");
            }

            System.out.println(line);
        }
    }

    /**
     * Main method – Entry point for the banner display application.
     * Initializes the character pattern maps and displays "OOPS" as an ASCII art banner
     */
    public static void main(String[] args) {

        // Create CharacterPatternMap array
        CharacterPatternMap[] charMaps = createCharacterPatternMaps();

        // Define the message to be displayed
        String message = "OOPS";

        // Print the banner message
        printMessage(message, charMaps);
    }
}
