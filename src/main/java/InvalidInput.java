package main.java;

public class InvalidInput extends BotError {

    public InvalidInput() {
        super("Error!");
    }

    @Override
    public String toString() {
        String line = super.toString() + " Invalid Input. Please type again.";
        return line;
    }
}
