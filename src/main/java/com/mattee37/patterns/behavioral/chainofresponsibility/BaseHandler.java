package com.mattee37.patterns.behavioral.chainofresponsibility;

public abstract class BaseHandler implements Handler {
    private Handler nextHandler;

    @Override
    public Handler setNext(Handler handler) {
        nextHandler = handler;
        return handler;
    }

    @Override
    public void handle(SupportRequest request) {
        if (nextHandler != null) {
            nextHandler.handle(request);
        } else {
            System.out.println("❌ No handler available for this request");
        }
    }
}
