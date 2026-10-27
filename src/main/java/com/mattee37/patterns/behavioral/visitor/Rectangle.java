package com.mattee37.patterns.behavioral.visitor;

public record Rectangle(int width, int height) implements Shape {
    @Override
    public void accept(ShapeVisitor visitor) {
        visitor.visitRectangle(this);
    }
}
