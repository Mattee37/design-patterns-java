package com.mattee37.patterns.behavioral.visitor;

import java.util.Locale;

public class AreaCalculator implements ShapeVisitor {
    @Override
    public void visitCircle(Circle circle) {
        double area = Math.PI * circle.radius() * circle.radius();
        System.out.println("⭕ Circle area: " + String.format(Locale.ROOT, "%.2f", area));
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        int area = rectangle.width() * rectangle.height();
        System.out.println("⬜ Rectangle area: " + area);
    }
}
