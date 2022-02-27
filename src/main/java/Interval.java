package main.java;

public class Interval implements Comparable<Interval> {

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

    @Override
    public int compareTo(Interval other) {
        if (other.end < this.end) return 1;
        else if (other.end > this.end) return 1;
        else if (other.start > this.start) return 1;
        else if (other.start < this.start) return -1;
        else return 0;
    }
}
