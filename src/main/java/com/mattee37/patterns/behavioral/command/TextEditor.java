package com.mattee37.patterns.behavioral.command;

public class TextEditor {
    private String content = "";

    public void write(String text) {
        content += text;
    }

    public void deleteLast(int count) {
        content = content.substring(0, Math.max(0, content.length() - count));
    }

    public String getContent() {
        return content;
    }

    public void print() {
        System.out.println("📝 Content: \"" + content + "\"");
    }
}
