package com.mattee37.patterns.creational.prototype;

public class Document implements Prototype<Document> {
    public String title;
    public String content;
    public String author;

    public Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Document clone() {
        return new Document(title, content, author);
    }

    public void print() {
        System.out.println("📄 \"" + title + "\" by " + author);
        System.out.println("   Content: " + content + "\n");
    }
}
