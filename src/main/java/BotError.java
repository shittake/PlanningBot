package main.java;

public class BotError {

    private String msg;

    public BotError(String msg) {
        this.msg = msg;
    }
    
    @Override
    public String toString() {
        return this.msg;
    }
}