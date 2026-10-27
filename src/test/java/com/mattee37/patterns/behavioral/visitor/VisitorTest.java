package com.mattee37.patterns.behavioral.visitor;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VisitorTest {

    private static String capture(Runnable action) {
        var buffer = new ByteArrayOutputStream();
        var original = System.out;
        try {
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString(StandardCharsets.UTF_8);
    }

    @Test
    void areaCalculatorDispatchesPerShapeType() {
        List<Shape> shapes = List.of(new Circle(5), new Rectangle(4, 6), new Circle(3));

        var output = capture(() -> shapes.forEach(shape -> shape.accept(new AreaCalculator())));

        assertTrue(output.contains("Circle area: 78.54"));
        assertTrue(output.contains("Rectangle area: 24"));
        assertTrue(output.contains("Circle area: 28.27"));
    }

    @Test
    void drawVisitorDispatchesPerShapeType() {
        List<Shape> shapes = List.of(new Circle(5), new Rectangle(4, 6));

        var output = capture(() -> shapes.forEach(shape -> shape.accept(new DrawVisitor())));

        assertTrue(output.contains("Drawing circle with radius 5"));
        assertTrue(output.contains("Drawing rectangle 4x6"));
    }

    @Test
    void sealedShapeAllowsExhaustiveSwitch() {
        Shape shape = new Circle(5);

        String description = switch (shape) {
            case Circle circle -> "circle:" + circle.radius();
            case Rectangle rectangle -> "rectangle:" + rectangle.width() + "x" + rectangle.height();
        };

        assertEquals("circle:5", description);
    }
}
