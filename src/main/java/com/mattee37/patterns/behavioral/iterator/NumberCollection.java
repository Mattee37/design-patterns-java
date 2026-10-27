package com.mattee37.patterns.behavioral.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class NumberCollection implements IterableCollection<Integer> {
    private final List<Integer> items = new ArrayList<>();

    public void add(Integer item) {
        items.add(item);
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new NumberIterator(items);
    }

    // honey: external iterator over the live list; do not mutate the collection mid-traversal
    private static final class NumberIterator implements Iterator<Integer> {
        private final List<Integer> collection;
        private int position = 0;

        NumberIterator(List<Integer> collection) {
            this.collection = collection;
        }

        @Override
        public boolean hasNext() {
            return position < collection.size();
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return collection.get(position++);
        }
    }
}
