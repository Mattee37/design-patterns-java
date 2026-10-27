package com.mattee37.patterns.behavioral.mediator;

public class ChatUser implements User {
    private final String name;
    private final Mediator mediator;

    public ChatUser(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public void send(String message) {
        System.out.println("💬 " + name + " sends: \"" + message + "\"");
        mediator.notify(name, message);
    }

    @Override
    public void receive(String from, String message) {
        System.out.println("   " + name + " received from " + from + ": \"" + message + "\"");
    }
}
