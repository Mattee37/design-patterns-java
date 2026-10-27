package com.mattee37.patterns.behavioral.visitor;

public class DrawVisitor implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        System.out.println("🎨 Drawing circle with radius " + circle.radius());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        System.out.println("🎨 Drawing rectangle " + rectangle.width() + "x" + rectangle.height());
    }
}
