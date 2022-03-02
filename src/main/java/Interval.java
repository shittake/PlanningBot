package main.java;

public class Interval implements Comparable<Interval> {

    private int start, end;
    private String name;
    private String startString, endString;
    private AvailableLocation availableLocation;

    public Interval(String name, String start, String end) {
        this.name = name;
        this.startString = start;
        this.endString = end;
        this.start = convert(start);
        this.end = convert(end);
        this.availableLocation = null;
    }


    public int convert(String time) {
        String[] splitUp = time.split(":");
        int hour = Integer.parseInt(splitUp[0]);
        int minute = Integer.parseInt(splitUp[1]);
        return hour * 60 + minute;
    }


    public int getStartTime() {
        return this.start;
    }

    public int getEndTime() {
        return this.end;
    }


    public void setLocation(int dummy) {
        this.availableLocation = new AvailableLocation(-1);
    }

    public void setLocation(AvailableLocation possibleLocation) {
        this.availableLocation = possibleLocation;
    }

    @Override
    public String toString() {
        String front = this.name + " (" + this.startString + " - " + this.endString + ")";
        if (this.availableLocation != null) {
            int locationNo = this.availableLocation.getClassroomNumber();
            if (locationNo == 0) {
                return front + " cannot be held anywhere.";
            } else {
                return front + " can be held in Location " + String.valueOf(locationNo);
            }
        } else {
            return front; 
        }
    }

    @Override
    public int compareTo(Interval other) {
        if (other.end < this.end) return 1;
        else if (other.end > this.end) return -1;
        else if (other.start > this.start) return 1;
        else if (other.start < this.start) return -1;
        else return 0;
    }
}
