package com.mattee37.patterns.behavioral.iterator;

import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        System.out.println("=== Iterator Pattern ===\n");

        NumberCollection collection = new NumberCollection();
        collection.add(10);
        collection.add(20);
        collection.add(30);
        collection.add(40);

        Iterator<Integer> iterator = collection.createIterator();

        System.out.println("Iterating through collection:");
        while (iterator.hasNext()) {
            System.out.println("  → " + iterator.next());
        }

        System.out.println("\nNew iterator (starts fresh):");
        Iterator<Integer> iterator2 = collection.createIterator();
        System.out.println("  First: " + iterator2.next());
        System.out.println("  Second: " + iterator2.next());
    }
}
