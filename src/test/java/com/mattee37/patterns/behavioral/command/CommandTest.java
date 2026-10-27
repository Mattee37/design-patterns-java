package com.mattee37.patterns.behavioral.command;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandTest {

    @Test
    void executeAppendsAndUndoRemovesLastWrite() {
        TextEditor editor = new TextEditor();
        CommandHistory history = new CommandHistory();

        history.execute(new WriteCommand(editor, "Hello"));
        assertEquals("Hello", editor.getContent());

        history.execute(new WriteCommand(editor, " World"));
        assertEquals("Hello World", editor.getContent());

        history.execute(new WriteCommand(editor, "!"));
        assertEquals("Hello World!", editor.getContent());

        history.undo();
        assertEquals("Hello World", editor.getContent());

        history.undo();
        assertEquals("Hello", editor.getContent());
    }

    @Test
    void undoOnEmptyHistoryIsIgnored() {
        TextEditor editor = new TextEditor();
        CommandHistory history = new CommandHistory();

        history.execute(new WriteCommand(editor, "abc"));
        history.undo();
        history.undo(); // extra undo — no-op, mirrors the falsy check in the TS version

        assertEquals("", editor.getContent());
    }
}
