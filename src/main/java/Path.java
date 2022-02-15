package main.java;
import java.util.Scanner;

public class Path {

    private String name;
    private Scanner scan;

    public Path(String name, Scanner scan) {
        this.name = name;
        this.scan = scan;
    }

    public void run() {
        System.out.println("Welcome!");
    }

    public int getInt() {
        return this.scan.nextInt();
    }

    public String getLine() { return this.scan.nextLine(); }

    public double getDouble() { return this.scan.getDouble(); }
    @Override
    public String toString() {
        return "Path ";
    }
}
