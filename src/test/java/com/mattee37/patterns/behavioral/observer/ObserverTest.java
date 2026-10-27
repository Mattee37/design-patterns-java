package com.mattee37.patterns.behavioral.observer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObserverTest {

    private static String capture(Runnable action) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString(StandardCharsets.UTF_8);
    }

    @Test
    void notifiesAllSubscribersOnPublish() {
        Newsletter newsletter = new Newsletter();
        newsletter.subscribe(new Subscriber("Alice"));
        newsletter.subscribe(new Subscriber("Bob"));

        String output = capture(() -> newsletter.publish("New TypeScript 5.0 Features!"));

        assertTrue(output.contains("Publishing: \"New TypeScript 5.0 Features!\""));
        assertTrue(output.contains("Alice received: \"New TypeScript 5.0 Features!\""));
        assertTrue(output.contains("Bob received: \"New TypeScript 5.0 Features!\""));
    }

    @Test
    void unsubscribedObserverIsNotNotified() {
        Newsletter newsletter = new Newsletter();
        Subscriber alice = new Subscriber("Alice");
        Subscriber bob = new Subscriber("Bob");
        newsletter.subscribe(alice);
        newsletter.subscribe(bob);

        String output = capture(() -> {
            newsletter.publish("First!");
            newsletter.unsubscribe(bob);
            newsletter.publish("Second!");
        });

        assertTrue(output.contains("Bob received: \"First!\""));
        assertTrue(output.contains("Alice received: \"Second!\""));
        assertFalse(output.contains("Bob received: \"Second!\""));
    }
}
