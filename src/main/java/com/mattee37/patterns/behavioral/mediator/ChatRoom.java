package com.mattee37.patterns.behavioral.mediator;

import java.util.LinkedHashMap;
import java.util.Map;

public class ChatRoom implements Mediator {
    // LinkedHashMap keeps registration order, like the JS Map in the TS version
    private final Map<String, User> users = new LinkedHashMap<>();

    public void register(User user) {
        users.put(user.name(), user);
        System.out.println("📥 " + user.name() + " joined the chat");
    }

    @Override
    public void notify(String sender, String message) {
        users.forEach((name, user) -> {
            if (!name.equals(sender)) {
                user.receive(sender, message);
            }
        });
    }
}
