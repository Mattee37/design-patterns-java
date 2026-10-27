package com.mattee37.patterns.structural.composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CompositeTest {

    @Test
    void fileReturnsItsOwnSize() {
        assertEquals(120, new File("resume.pdf", 120).getSize());
    }

    @Test
    void folderRecursivelySumsChildren() {
        Folder root = new Folder("root");
        Folder documents = new Folder("documents");

        documents.add(new File("resume.pdf", 120));
        documents.add(new File("notes.txt", 5));

        root.add(documents);
        root.add(new File("readme.md", 2));

        assertEquals(127, root.getSize());
    }
}
