package com.mattee37.patterns.structural.flyweight;

public record Tree(double x, double y, TreeType type) {
    public void draw() {
        type.draw(x, y);
    }
}
