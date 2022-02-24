package main.java;
import java.util.ArrayList;
import java.util.Scanner;

public class PathA extends Path {

    private ArrayList<Interval> lstOfEvents;
    public PathA(String name, Scanner scan) {
        super(name, scan);
        this.lstOfEvents = new ArrayList<>();
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
        collectEvents(Integer.valueOf(answer));
    }

    public void collectEvents(int answer) {
        for (int i = 0; i < answer; i++) {
            // For now, assume all valid inputs
            System.out.println("Please key in the time which Event " + String.valueOf(i+1) + " starts.");
            String startTime = getLine();
            System.out.println("Please key in the time which Event " + String.valueOf(i+1) + " ends.");
            String endTime = getLine();

            Interval event = new Interval(startTime, endTime);
            this.lstOfEvents.add(event);

            printEvents();
        }
    }

    public void printEvents() {
        for (int i = 0; i < this.lstOfEvents.size(); i++) {
            System.out.print("Event " + String.valueOf(i+1) + ": ");
            System.out.println(this.lstOfEvents.get(i));
        }
    }
    @Override
    public String toString() {
        return super.toString() + "A";
    }
}
