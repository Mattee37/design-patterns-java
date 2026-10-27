package com.mattee37.patterns.behavioral.memento;

import java.time.Instant;

public class Editor {
    private String content = "";

    public void type(String text) {
        content += text;
    }

    public String getContent() {
        return content;
    }

    public Memento save() {
        return new EditorMemento(content, Instant.now());
    }

    public void restore(Memento memento) {
        content = memento.getState();
    }
}

// Package-private: only the Editor creates and reads its own snapshots
record EditorMemento(String state, Instant date) implements Memento {
    @Override
    public String getState() {
        return state;
    }

    @Override
    public String getDate() {
        return date.toString();
    }
}
