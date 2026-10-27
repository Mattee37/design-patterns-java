package com.mattee37.patterns.behavioral.iterator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IteratorTest {

    private static NumberCollection sample() {
        NumberCollection collection = new NumberCollection();
        collection.add(10);
        collection.add(20);
        collection.add(30);
        collection.add(40);
        return collection;
    }

    @Test
    void iteratesAllItemsInInsertionOrder() {
        Iterator<Integer> iterator = sample().createIterator();
        ArrayList<Integer> items = new ArrayList<Integer>();
        while (iterator.hasNext()) {
            items.add(iterator.next());
        }

        assertEquals(List.of(10, 20, 30, 40), items);
    }

    @Test
    void eachIteratorStartsFresh() {
        NumberCollection collection = sample();

        Iterator<Integer> first = collection.createIterator();
        assertEquals(10, first.next());
        assertEquals(20, first.next());

        Iterator<Integer> second = collection.createIterator();
        assertEquals(10, second.next());
        assertEquals(20, second.next());
    }

    @Test
    void hasNextIsFalseAfterExhaustion() {
        Iterator<Integer> iterator = sample().createIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }

        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}
