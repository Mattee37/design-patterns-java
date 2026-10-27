package com.mattee37.patterns.behavioral.memento;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MementoTest {

    @Test
    void restoresPreviouslySavedStates() {
        var editor = new Editor();
        var history = new History();

        editor.type("Hello");
        history.push(editor.save());
        editor.type(" World");
        history.push(editor.save());
        editor.type("!!!");
        assertEquals("Hello World!!!", editor.getContent());

        history.pop().ifPresent(editor::restore);
        assertEquals("Hello World", editor.getContent());

        history.pop().ifPresent(editor::restore);
        assertEquals("Hello", editor.getContent());
    }

    @Test
    void poppingEmptyHistoryIsANoOp() {
        var editor = new Editor();
        var history = new History();
        editor.type("data");

        assertTrue(history.pop().isEmpty());
        assertEquals("data", editor.getContent());
    }

    @Test
    void mementoExposesSnapshotAndIsoDate() {
        var editor = new Editor();
        editor.type("Hello");
        Memento memento = editor.save();

        assertEquals("Hello", memento.getState());
        assertNotNull(Instant.parse(memento.getDate())); // ISO-8601, parseable
    }
}
