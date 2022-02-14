package main.java;
import java.util.Scanner;

public class PathA extends Path {

    public PathA(String name, Scanner scan) {
        super(name, scan);
    }

    public void run() {
        super.run();
        System.out.println("To start off, how many events are you planning to conduct in total?");
        int answer = getInt();
    }

    @Override
    public String toString() {
        return super.toString() + "A";
    }
}
