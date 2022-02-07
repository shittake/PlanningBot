package main.java;

public class TimeOutOfBounds extends InvalidInput{

    public TimeOutOfBounds() {
    }

    @Override
    public String toString() {
        String line = "Time does not make sense! ";
        return line + super.toString();
    }
}
