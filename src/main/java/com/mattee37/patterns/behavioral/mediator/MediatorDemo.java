package com.mattee37.patterns.behavioral.mediator;

public class MediatorDemo {
    public static void main(String[] args) {
        System.out.println("=== Mediator Pattern ===\n");

        var chatRoom = new ChatRoom();

        var alice = new ChatUser("Alice", chatRoom);
        var bob = new ChatUser("Bob", chatRoom);
        var charlie = new ChatUser("Charlie", chatRoom);

        chatRoom.register(alice);
        chatRoom.register(bob);
        chatRoom.register(charlie);

        System.out.println("");
        alice.send("Hello everyone!");
        System.out.println("");
        bob.send("Hi Alice!");
    }
}
