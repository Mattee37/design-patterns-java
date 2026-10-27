package com.mattee37.patterns.structural.composite;

public class CompositeDemo {
    public static void main(String[] args) {
        System.out.println("=== Composite Pattern ===\n");

        Folder root = new Folder("root");
        Folder documents = new Folder("documents");
        Folder images = new Folder("images");

        documents.add(new File("resume.pdf", 120));
        documents.add(new File("notes.txt", 5));

        images.add(new File("photo.jpg", 2500));
        images.add(new File("icon.png", 15));

        root.add(documents);
        root.add(images);
        root.add(new File("readme.md", 2));

        root.print();

        System.out.println("\nTotal size: " + root.getSize() + "KB");
    }
}
