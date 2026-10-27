package com.mattee37.patterns.behavioral.visitor;

public sealed interface Shape permits Circle, Rectangle {
    void accept(ShapeVisitor visitor);
}
