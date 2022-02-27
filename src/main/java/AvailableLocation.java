package main.java;

public class AvailableLocation implements Comparable<AvailableLocation> {

    private int classroomNumber;
    private int availableFrom;

    public AvailableLocation(int indexOfClassoom) {
        this.classroomNumber = indexOfClassoom + 1;
        this.availableFrom = 0;
    }

    public String convertToTime() {
        int minutes = this.availableFrom % 60;
        int hours = this.availableFrom / 60;
        String hoursPortion = (hours >= 10) ? String.valueOf(hours) : "0" + String.valueOf(hours);
        String minutesPortion = (minutes <= 9) ? "0" + String.valueOf(minutes) : String.valueOf(minutes);
        return hoursPortion + ":" + minutesPortion;
    }

    @Override
    public String toString() {
        String first = "Classroom " + String.valueOf(this.classroomNumber) + " is available from ";
        return first + convertToTime();
    }

    @Override
    public int compareTo(AvailableLocation other) {
        if (other.availableFrom < this.availableFrom) return 1;
        else if (other.availableFrom > this.availableFrom) return -1;
        else return other.classroomNumber - this.classroomNumber;
    }
}