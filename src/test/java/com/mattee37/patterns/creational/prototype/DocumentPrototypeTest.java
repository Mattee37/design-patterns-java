package com.mattee37.patterns.creational.prototype;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class DocumentPrototypeTest {

    @Test
    void cloneCopiesAllFields() {
        Document original = new Document("Template", "Some content", "Author");
        Document copy = original.clone();

        assertNotSame(original, copy);
        assertEquals(original.title, copy.title);
        assertEquals(original.content, copy.content);
        assertEquals(original.author, copy.author);
    }

    @Test
    void cloneIsIndependentOfOriginal() {
        Document original = new Document("Template", "Some content", "Author");
        Document copy = original.clone();

        copy.title = "Changed";

        assertEquals("Template", original.title);
        assertEquals("Changed", copy.title);
    }
}
