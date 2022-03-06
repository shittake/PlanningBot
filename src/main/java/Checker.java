package main.java;

import org.omg.CORBA.DynAnyPackage.Invalid;

public class Checker {

    // Returns 1 if the user typed "yes" or "y"
    // Returns 0 if the user typed "no" or "n"
    // Returns -1 for all other invalid input
    public static int yesNoCheck(String line) {

        // Firstly, check for non-alphabets in the String
        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (!Character.isAlphabetic(current)) {
                // Throw custom InvalidInput Error that is a subclass of the BotError class
                InvalidInput error = new InvalidInput();
                System.out.println(error);
                return -1;
            }
        }

        String convert = line.toLowerCase();

        if (convert.equals("yes") || convert.equals("y")) {
            return 1;
        } else if (convert.equals("no") || convert.equals("n")) {
            return 0;
        } else {
            InvalidInput error = new InvalidInput();
            System.out.println(error);
            return -1;
        }
    }

    public static boolean intChecker(String line) {
        for (int i = 0; i < line.length(); i++) {
            if (!Character.isDigit(line.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean validTime(String time) {
        if (!time.contains(":")) {
            InvalidInput error = new InvalidInput();
            System.out.println(error);
        } else {
            String[] split = time.split(":");
            if (split.length != 2 || !intChecker(split[0]) || !intChecker(split[1])) {
                InvalidInput error = new InvalidInput();
                System.out.println(error);
            } else if (split[1].length() != 2) {
                InvalidInput error = new InvalidInput();
                System.out.println(error);
            } else {
                int hour = Integer.parseInt(split[0]);
                int minute = Integer.parseInt(split[1]);
                if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60) {
                    InvalidInput error = new TimeOutOfBounds();
                    System.out.println(error);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean validTime(String start, String end) {
        if (!validTime(end)) {
            return false;
        } else {
            String[] splitUpStart = start.split(":");
            String[] splitUpEnd = end.split(":");
            int hour = Integer.parseInt(splitUpStart[0]);
            int minute = Integer.parseInt(splitUpStart[1]);
            int startTime = hour * 60 + minute;

            hour = Integer.parseInt(splitUpEnd[0]);
            minute = Integer.parseInt(splitUpEnd[1]);
            int endTime = hour * 60 + minute;

            if (endTime <= startTime) {
                InvalidInput error = new TimeConflict();
                System.out.println(error);
                return false;
            } else {
                return true;
            }
        }
    }
}
