package com.mattee37.patterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

public class Newsletter implements Subject {
    private final List<Observer> subscribers = new ArrayList<>();

    @Override
    public void subscribe(Observer observer) {
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        subscribers.remove(observer);
    }

    @Override
    public void notify(String message) {
        subscribers.forEach(observer -> observer.update(message));
    }

    public void publish(String article) {
        System.out.println("📰 Publishing: \"" + article + "\"");
        notify(article);
    }
}
