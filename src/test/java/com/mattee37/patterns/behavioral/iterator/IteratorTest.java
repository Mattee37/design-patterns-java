package com.mattee37.patterns.behavioral.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IteratorTest {

    private static NumberCollection sample() {
        var collection = new NumberCollection();
        collection.add(10);
        collection.add(20);
        collection.add(30);
        collection.add(40);
        return collection;
    }

    @Test
    void iteratesAllItemsInInsertionOrder() {
        var iterator = sample().createIterator();
        var items = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            items.add(iterator.next());
        }

        assertEquals(List.of(10, 20, 30, 40), items);
    }

    @Test
    void eachIteratorStartsFresh() {
        var collection = sample();

        var first = collection.createIterator();
        assertEquals(10, first.next());
        assertEquals(20, first.next());

        var second = collection.createIterator();
        assertEquals(10, second.next());
        assertEquals(20, second.next());
    }

    @Test
    void hasNextIsFalseAfterExhaustion() {
        var iterator = sample().createIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
