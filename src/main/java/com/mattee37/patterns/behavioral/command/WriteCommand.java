package com.mattee37.patterns.behavioral.command;

public class WriteCommand implements Command {
    private final TextEditor editor;
    private final String text;

    public WriteCommand(TextEditor editor, String text) {
        this.editor = editor;
        this.text = text;
    }

    @Override
    public void execute() {
        editor.write(text);
    }

    @Override
    public void undo() {
        editor.deleteLast(text.length());
    }
}
