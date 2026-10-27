package com.mattee37.patterns.behavioral.visitor;

public interface ShapeVisitor {
    void visitCircle(Circle circle);

    void visitRectangle(Rectangle rectangle);
}
