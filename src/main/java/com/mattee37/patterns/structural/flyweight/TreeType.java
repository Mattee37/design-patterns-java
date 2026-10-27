package com.mattee37.patterns.structural.flyweight;

public interface TreeType {
    String name();

    String color();

    String texture();

    void draw(double x, double y);
}

record TreeTypeImpl(String name, String color, String texture) implements TreeType {
    @Override
    public void draw(double x, double y) {
        System.out.println("🌳 " + name + " (" + color + ") at (" + x + ", " + y + ")");
    }
}
