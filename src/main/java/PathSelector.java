package main.java;
import java.util.Scanner;

public class PathSelector {

    private String name;
    private Scanner scan;
    public PathSelector(String name, Scanner scan) {
        this.name = name;
        this.scan = scan;
    }

    public void run() {
        System.out.println("Hi " + this.name);
        System.out.println("Which path would you like to choose?");

        String reply = scan.nextLine();
        while (!reply.equals("A") && !reply.equals("B")) {
            System.out.println("Invalid Command. Type again.");
            reply = scan.nextLine();
        }
        System.out.println("Very well! You chose " + reply);
    }
}
