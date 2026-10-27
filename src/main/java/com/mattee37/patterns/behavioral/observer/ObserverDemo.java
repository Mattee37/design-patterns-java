package com.mattee37.patterns.behavioral.observer;

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("=== Observer Pattern ===\n");

        Newsletter newsletter = new Newsletter();

        Subscriber alice = new Subscriber("Alice");
        Subscriber bob = new Subscriber("Bob");
        Subscriber charlie = new Subscriber("Charlie");

        newsletter.subscribe(alice);
        newsletter.subscribe(bob);
        newsletter.subscribe(charlie);

        newsletter.publish("New TypeScript 5.0 Features!");

        System.out.println("\nBob unsubscribes...\n");
        newsletter.unsubscribe(bob);

        newsletter.publish("Bun 1.0 Released!");
    }
}
