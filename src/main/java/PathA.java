package main.java;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class PathA extends Path {

    private ArrayList<Interval> lstOfEvents;
    private int numberOfPlaces;

    public PathA(String name, Scanner scan) {
        super(name, scan);
        this.lstOfEvents = new ArrayList<>();
        this.numberOfPlaces = 0;
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
        System.out.println("You have a total of " + answer + " events.");

        collectEvents(Integer.valueOf(answer));
        System.out.println("How many locations do you have available?"); // All these should be better abstracted
        answer = getLine();

        while (!Checker.intChecker(answer)) {
            BotError error = new InvalidInput();
            System.out.println(error);
            answer = getLine();
        }
        System.out.println("You have a total of " + answer + " locations.");
        this.numberOfPlaces = Integer.parseInt(answer);

        allocateEvents();
    }

    public void collectEvents(int answer) {
        while (this.lstOfEvents.size() < answer) {// modify this to while loop in the future
            Interval event = createEvent();
            this.lstOfEvents.add(event);
            printEvents();
        }
    }

    public Interval createEvent() {
        // Assume all times provided are valid for now
        int currentEvent = this.lstOfEvents.size() + 1;

        System.out.println("What is the name of Event " + String.valueOf(currentEvent) + "?");
        String name = getLine();
        System.out.println("Please key in the time which " + name + " starts.");
        String startTime = getLine();
        System.out.println("Please key in the time which " + name + " ends.");
        String endTime = getLine();

        Interval event = new Interval(name, startTime, endTime);

        return event;
    }

    public void printEvents() {
        for (int i = 0; i < this.lstOfEvents.size(); i++) {
            System.out.print("[Event " + String.valueOf(i+1) + "] ");
            System.out.println(this.lstOfEvents.get(i));
        }
        askRemoveEvents();
    }

    public void askRemoveEvents() {
        System.out.println("Would you to remove any of the events?");
        String reply = getLine();
        int result = Checker.yesNoCheck(reply);

        // Performs input validation and confirmation until user is satisfied
        while (result != 0) {
            if (result == 1) {
                System.out.print("Which event would you like to remove? Type the event number here: ");

                String toBeRemoved = getLine();
                removeEvents(toBeRemoved);

                System.out.println("Would you still like to remove any events?");
            }
            reply = getLine();
            result = Checker.yesNoCheck(reply);
        }
    }

    public void removeEvents(String toBeRemoved) {
        // assume valid inputs for now
        int index = Integer.parseInt(toBeRemoved);  // assume this is valid for now
        System.out.println("Event " + String.valueOf(index) + " is removed."); // put this into another method
        this.lstOfEvents.remove(index - 1);
    }

    public void allocateEvents() {
        TreeSet<AvailableLocation> allLocations = new TreeSet<>();
        for (int i = 0; i < this.numberOfPlaces; i++){
            allLocations.add(new AvailableLocation(i));
        }

        TreeSet<Interval> allEvents = new TreeSet<>();
        for (int i = 0; i < this.lstOfEvents.size(); i++) {
            Interval currentEvent = this.lstOfEvents.get(i);
            allEvents.add(currentEvent);
        }

        while (!allEvents.isEmpty()) {
            Interval currentEvent = allEvents.first();
            //System.out.println(currentEvent);
            allEvents.remove(currentEvent);

            // We want to find if there are any locations available, with an available timing that is closest to our event's start time
            // This can maximize the number of events we can carry out
            AvailableLocation dummyLocation = new AvailableLocation(Integer.MAX_VALUE, currentEvent.getStartTime());

            // Assuming no delays and the location is immediately available after the previous event has concluded
            AvailableLocation possibleLocation = allLocations.floor(dummyLocation);

            if (possibleLocation == null) {
                currentEvent.setLocation(-1);
            } else {
                currentEvent.setLocation(possibleLocation);
                allLocations.remove(possibleLocation);
                possibleLocation.update(currentEvent);
                allLocations.add(possibleLocation);
            }
        }
        printAllocations();
    }

    public void printAllocations() {
        for (int i = 0; i < this.lstOfEvents.size(); i++) {
            System.out.println(this.lstOfEvents.get(i));
        }
    }

    @Override
    public String toString() {
        return super.toString() + "A";
    }
}
