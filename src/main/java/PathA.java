package main.java;
import java.util.ArrayList;
import java.util.Scanner;

public class PathA extends Path {

    private ArrayList<Interval> lstOfEvents;
    public PathA(String name, Scanner scan) {
        super(name, scan);
    }

    public void run() {
        super.run();
        System.out.println("To start off, how many events are you planning to conduct in total?");
        String answer = getLine();

        while (!Checker.intChecker(answer)) {
            BotError error = new InvalidInput();
            System.out.println(error);
            answer = getLine();
        }
        System.out.println("You have a total of " + String.valueOf(answer) + " events");
        collectEvents(answer);
    }
    
    @Override
    public String toString() {
        return super.toString() + "A";
    }
}
