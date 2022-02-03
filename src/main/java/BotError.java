package main.java;

// BotError class is the superclass of all custom error classes that could be encountered in PlanningBot
public class BotError {

    private String msg;

    // Allows for custom generic error message
    public BotError(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.msg;
    }
}