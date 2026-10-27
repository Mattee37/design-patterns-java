package com.mattee37.patterns.behavioral.observer;

public class Subscriber implements Observer {
    private final String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("   📧 " + name + " received: \"" + message + "\"");
    }
}
