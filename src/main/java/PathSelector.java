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
        System.out.println("You have some events happening and some locations available. You wish to find an optimal way to schedule the events.");
        System.out.println("Path A: Events can be conducted back-to-back without any downtime required.");
        System.out.println("Path B: There is downtime required after each event (cleaning up / rest time) etc.");
        System.out.println("This is caps sensitive!");
        System.out.println();

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
