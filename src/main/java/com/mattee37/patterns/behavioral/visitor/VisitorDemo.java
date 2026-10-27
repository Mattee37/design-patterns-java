package com.mattee37.patterns.behavioral.visitor;

import java.util.List;

public class VisitorDemo {
    public static void main(String[] args) {
        System.out.println("=== Visitor Pattern ===\n");

        List<Shape> shapes = List.of(new Circle(5), new Rectangle(4, 6), new Circle(3));

        System.out.println("Calculating areas:");
        var areaCalculator = new AreaCalculator();
        shapes.forEach(shape -> shape.accept(areaCalculator));

        System.out.println("\nDrawing shapes:");
        var drawer = new DrawVisitor();
        shapes.forEach(shape -> shape.accept(drawer));
    }
}
