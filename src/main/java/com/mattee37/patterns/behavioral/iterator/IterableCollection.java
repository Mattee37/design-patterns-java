package com.mattee37.patterns.behavioral.iterator;

import java.util.Iterator;

public interface IterableCollection<T> {
    Iterator<T> createIterator();
}
