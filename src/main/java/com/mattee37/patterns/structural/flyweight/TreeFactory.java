package com.mattee37.patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public final class TreeFactory {
    private static final Map<String, TreeType> treeTypes = new HashMap<>();

    private TreeFactory() {
    }

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;

        if (!treeTypes.containsKey(key)) {
            System.out.println("  [Factory] Creating new TreeType: " + name);
            treeTypes.put(key, new TreeTypeImpl(name, color, texture));
        }

        return treeTypes.get(key);
    }

    public static int getTypeCount() {
        return treeTypes.size();
    }
}
