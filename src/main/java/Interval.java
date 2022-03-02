package main.java;

public class Interval implements Comparable<Interval> {

    private int start, end;
    private int eventNo;
    private String name;
    private String startString, endString;

    public Interval(String name, String start, String end) {
        this.name = name;
        this.startString = start;
        this.endString = end;
        this.start = convert(start);
        this.end = convert(end);
        this.eventNo = 0;
    }


    public int convert(String time) {
        String[] splitUp = time.split(":");
        int hour = Integer.parseInt(splitUp[0]);
        int minute = Integer.parseInt(splitUp[1]);
        return hour * 60 + minute;
    }

    public void setEventNo(int number) {
        this.eventNo = number;
    }

    public int getStartTime() {
        return this.start;
    }

    public int getEndTime() {
        return this.end;
    }

    public int getEventNo() {
        return this.eventNo;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.startString + " - " + this.endString;
    }

    @Override
    public int compareTo(Interval other) {
        if (other.end < this.end) return 1;
        else if (other.end > this.end) return -1;
        else if (other.start > this.start) return 1;
        else if (other.start < this.start) return -1;
        else return this.eventNo - other.eventNo;
    }
}
