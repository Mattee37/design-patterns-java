package com.mattee37.patterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class FlyweightDemo {
    public static void main(String[] args) {
        System.out.println("=== Flyweight Pattern ===\n");

        System.out.println("Creating forest with shared tree types:\n");

        List<Tree> trees = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            TreeType oakType = TreeFactory.getTreeType("Oak", "green", "rough");
            trees.add(new Tree(Math.random() * 100, Math.random() * 100, oakType));
        }

        for (int i = 0; i < 3; i++) {
            TreeType pineType = TreeFactory.getTreeType("Pine", "dark-green", "smooth");
            trees.add(new Tree(Math.random() * 100, Math.random() * 100, pineType));
        }

        System.out.println("\nTotal trees: " + trees.size());
        System.out.println("Unique tree types: " + TreeFactory.getTypeCount());

        System.out.println("\nDrawing first 4 trees:");
        trees.subList(0, 4).forEach(Tree::draw);
    }
}
