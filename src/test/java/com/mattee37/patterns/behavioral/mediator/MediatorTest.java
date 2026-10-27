package com.mattee37.patterns.behavioral.mediator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MediatorTest {

    private record Message(String from, String message) {
    }

    private static final class RecordingUser implements User {
        private final String name;
        private final List<Message> received = new ArrayList<>();

        RecordingUser(String name) {
            this.name = name;
        }

        @Override
        public String name() {
            return name;
        }

        @Override
        public void send(String message) {
        }

        @Override
        public void receive(String from, String message) {
            received.add(new Message(from, message));
        }
    }

    @Test
    void broadcastReachesEveryUserExceptSender() {
        var room = new ChatRoom();
        var alice = new RecordingUser("Alice");
        var bob = new RecordingUser("Bob");
        var charlie = new RecordingUser("Charlie");
        room.register(alice);
        room.register(bob);
        room.register(charlie);

        room.notify("Alice", "Hello everyone!");

        assertEquals(List.of(), alice.received);
        assertEquals(List.of(new Message("Alice", "Hello everyone!")), bob.received);
        assertEquals(List.of(new Message("Alice", "Hello everyone!")), charlie.received);
    }

    @Test
    void chatUserSendReachesOthersThroughMediator() {
        var room = new ChatRoom();
        var alice = new ChatUser("Alice", room);
        var bob = new RecordingUser("Bob");
        room.register(alice);
        room.register(bob);

        alice.send("Hi Alice!");

        assertEquals(List.of(new Message("Alice", "Hi Alice!")), bob.received);
    }
}
