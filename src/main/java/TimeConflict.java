package main.java;

public class TimeConflict extends TimeOutOfBounds {

    public TimeConflict() {}

    @Override
    public String toString() {
        String line = "End time is earlier than start time! ";

        return line + super.toString();
    }
}
