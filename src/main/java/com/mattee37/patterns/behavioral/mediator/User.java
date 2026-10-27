package com.mattee37.patterns.behavioral.mediator;

public interface User {
    String name();
    void send(String message);
    void receive(String from, String message);
}
