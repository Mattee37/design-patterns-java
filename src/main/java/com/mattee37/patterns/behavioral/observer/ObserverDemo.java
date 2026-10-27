package com.mattee37.patterns.behavioral.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern ===\n");

        var newsletter = new Newsletter();

        var alice = new Subscriber("Alice");
        var bob = new Subscriber("Bob");
        var charlie = new Subscriber("Charlie");

        newsletter.subscribe(alice);
        newsletter.subscribe(bob);
        newsletter.subscribe(charlie);

        newsletter.publish("New TypeScript 5.0 Features!");

        System.out.println("\nBob unsubscribes...\n");
        newsletter.unsubscribe(bob);

        newsletter.publish("Bun 1.0 Released!");
    }
}
