package com.mattee37.patterns.behavioral.chainofresponsibility;

public interface Handler {
    Handler setNext(Handler handler);
    void handle(SupportRequest request);
}
