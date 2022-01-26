package main.java;

public class Checker {

    // Pre-condition: Assumes that the line consist of only alphabets as characters
    // Returns 1 if the user typed "yes" or "y"
    // Returns 0 if the user typed "no" or "n"
    // Returns -1 for all other invalid input
    public static int yesNoCheck(String line) {
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
