package main.java;
import java.util.Scanner;

public class Interactor {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Sends welcome message and kickstarts program
        welcome(scan);
    }

    public static void welcome(Scanner scan) {
        System.out.println("Welcome to PlanningBot!");
        System.out.println("Type Y (yes) or N (no) when answering any yes/no questions.");
        System.out.print("Please enter your name: ");

        // Gets user to input name
        String name = scan.nextLine();
        System.out.println("Hello " + name + ". Is this correct?");

        String reply = scan.nextLine();
        int result = Checker.yesNoCheck(reply);

        // Performs input validation and confirmation until user is satisfied
        while (result != 1) {
            if (result == 0) {
                System.out.print("Previous result deleted. Please re-enter your name: ");
                name = scan.nextLine();
                System.out.println("Hello " + name + ". Is this correct?");
            }
            reply = scan.nextLine();
            result = Checker.yesNoCheck(reply);
        }

        // After the introduction, moves to the second phase - the purpose of the bot
        PathSelector pathselector = new PathSelector(name, scan);
        pathselector.run();
    }
}
