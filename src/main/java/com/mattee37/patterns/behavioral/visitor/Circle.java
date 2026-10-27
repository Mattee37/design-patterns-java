package com.mattee37.patterns.behavioral.visitor;

public record Circle(int radius) implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitCircle(this);
    }
}
