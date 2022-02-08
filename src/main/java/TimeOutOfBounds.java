package main.java;

// This is a specific error class that is raised when the time provided is outside a normal range
// For example, providing any time other than midnight/noon/12am to 11.59am, 12pm to 11.59pm will raise this error
public class TimeOutOfBounds extends InvalidInput{

    public TimeOutOfBounds() {}

    @Override
    public String toString() {
        String line = "Time does not make sense! ";
        return line + super.toString();
    }
}
