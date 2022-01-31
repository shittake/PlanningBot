package main.java;

public class Checker {

    // Returns 1 if the user typed "yes" or "y"
    // Returns 0 if the user typed "no" or "n"
    // Returns -1 for all other invalid input
    public static int yesNoCheck(String line) {

        // Firstly, check for non-alphabets in the String
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (!Character.isAlphabetic(current)) {
                return -1;
            }
        }

        String convert = line.toLowerCase();

        if (convert.equals("yes") || convert.equals("y")) {
            return 1;
        } else if (convert.equals("no") || convert.equals("n")) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void invalidInput() {
        System.out.println("Invalid input. Please re-type.");
    }
}