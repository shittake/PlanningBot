package main.java;

public class Interval {

    private int start, end;
    private String startString, endString;

    public Interval(String start, String end) {
        this.startString = start;
        this.endString = end;
        this.start = convert(start);
        this.end = convert(end);
    }

    public int convert(String time) {
        String[] splitUp = time.split(":");
        int hour = Integer.parseInt(splitUp[0]);
        int minute = Integer.parseInt(splitUp[1]);
        return hour * 60 + minute;
    }

    @Override
    public String toString() {
        return this.startString + " - " + this.endString;
    }
}