package com.mattee37.patterns.behavioral.observer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ObserverTest {

    private static String capture(Runnable action) {
        var buffer = new ByteArrayOutputStream();
        var original = System.out;
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
        var newsletter = new Newsletter();
        newsletter.subscribe(new Subscriber("Alice"));
        newsletter.subscribe(new Subscriber("Bob"));

        var output = capture(() -> newsletter.publish("New TypeScript 5.0 Features!"));

        assertTrue(output.contains("Publishing: \"New TypeScript 5.0 Features!\""));
        assertTrue(output.contains("Alice received: \"New TypeScript 5.0 Features!\""));
        assertTrue(output.contains("Bob received: \"New TypeScript 5.0 Features!\""));
    }

    @Test
    void unsubscribedObserverIsNotNotified() {
        var newsletter = new Newsletter();
        var alice = new Subscriber("Alice");
        var bob = new Subscriber("Bob");
        newsletter.subscribe(alice);
        newsletter.subscribe(bob);

        var output = capture(() -> {
            newsletter.publish("First!");
            newsletter.unsubscribe(bob);
            newsletter.publish("Second!");
        });

        assertTrue(output.contains("Bob received: \"First!\""));
        assertTrue(output.contains("Alice received: \"Second!\""));
        assertFalse(output.contains("Bob received: \"Second!\""));
    }
}
