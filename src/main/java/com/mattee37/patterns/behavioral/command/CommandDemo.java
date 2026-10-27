package com.mattee37.patterns.behavioral.command;

public class CommandDemo {
    public static void main(String[] args) {
        System.out.println("=== Command Pattern ===\n");

        TextEditor editor = new TextEditor();
        CommandHistory history = new CommandHistory();

        history.execute(new WriteCommand(editor, "Hello"));
        editor.print();

        history.execute(new WriteCommand(editor, " World"));
        editor.print();

        history.execute(new WriteCommand(editor, "!"));
        editor.print();

        System.out.println("\nUndo last command:");
        history.undo();
        editor.print();

        System.out.println("\nUndo again:");
        history.undo();
        editor.print();
    }
}
