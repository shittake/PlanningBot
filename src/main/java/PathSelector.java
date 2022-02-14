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
        System.out.println("Path A: You have some events happening and some locations available. You wish to find an optimal way to schedule the events.");
        System.out.println("Path B: You have some items and some people who have stated their preferences for the items. You wish to find an optimal way to distribute the items.");
        System.out.println("This is caps sensitive!");
        String reply = scan.nextLine();
        while (!reply.equals("A") && !reply.equals("B")) {
            InvalidInput error = new InvalidInput();
            System.out.println(error);
            reply = scan.nextLine();
        }
        System.out.println("Very well! You chose " + reply);
        if (reply.equals("A")) {
            moveA();
        } else {
            moveB();
        }
    }

    public void moveA() {
        Path current = new PathA(this.name, this.scan);
        current.run();
    }

    public void moveB() {
        System.out.println("Placeholder");
    }
}
