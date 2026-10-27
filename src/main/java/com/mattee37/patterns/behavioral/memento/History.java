package com.mattee37.patterns.behavioral.memento;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Optional;

public class History {
    private final Deque<Memento> mementos = new ArrayDeque<>();

    public void push(Memento memento) {
        mementos.push(memento);
    }

    public Optional<Memento> pop() {
        return Optional.ofNullable(mementos.poll());
    }
}
