package com.mattee37.patterns.behavioral.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class CommandHistory {
    private final Deque<Command> history = new ArrayDeque<>();

    public void execute(Command command) {
        command.execute();
        history.push(command);
    }

    public void undo() {
        Command command = history.poll();
        if (command != null) {
            command.undo();
        }
    }
}
