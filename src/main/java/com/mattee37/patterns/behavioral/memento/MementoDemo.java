package com.mattee37.patterns.behavioral.memento;

public class MementoDemo {
    public static void main(String[] args) {
        System.out.println("=== Memento Pattern ===\n");

        Editor editor = new Editor();
        History history = new History();

        editor.type("Hello");
        history.push(editor.save());
        System.out.println("📝 State 1: \"" + editor.getContent() + "\"");

        editor.type(" World");
        history.push(editor.save());
        System.out.println("📝 State 2: \"" + editor.getContent() + "\"");

        editor.type("!!!");
        System.out.println("📝 State 3: \"" + editor.getContent() + "\"");

        System.out.println("\nRestoring to previous state...");
        history.pop().ifPresent(memento -> {
            editor.restore(memento);
            System.out.println("📝 Restored: \"" + editor.getContent() + "\"");
        });

        System.out.println("\nRestoring again...");
        history.pop().ifPresent(memento -> {
            editor.restore(memento);
            System.out.println("📝 Restored: \"" + editor.getContent() + "\"");
        });
    }
}
