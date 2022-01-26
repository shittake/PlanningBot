package main.java;
import java.util.Scanner;

public class Interactor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        welcome(scan);
    }

    public static void welcome(Scanner scan) {
        System.out.println("Welcome to PlanningBot!");
        System.out.println("Type Y (yes) or N (no) when answering any yes/no questions.");
        System.out.print("Please enter your name: ");

        String name = scan.nextLine();
        System.out.println("Hello " + name + ". Is this correct?");

        String reply = scan.nextLine().toLowerCase();
        while (!reply.equals("yes") && !reply.equals("y")) {
            System.out.print("Previous result deleted. Please re-enter your name: ");
            name = scan.nextLine();
            System.out.println("Hello " + name + ". Is this correct?");
            reply = scan.nextLine().toLowerCase();
        }

        PathSelector pathselector = new PathSelector(name);
        pathselector.run();
    }
}
