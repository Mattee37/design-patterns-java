package com.mattee37.patterns.behavioral.interpreter;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InterpreterTest {

    private final Map<String, Double> context = new HashMap<>(Map.of("x", 10.0, "y", 5.0));

    @Test
    void evaluatesMultiplyOfSum() {
        // (x + y) * 2
        Expression expression = new MultiplyExpression(
                new AddExpression(new VariableExpression("x"), new VariableExpression("y")),
                new NumberExpression(2));

        assertEquals(30.0, expression.interpret(context));
    }

    @Test
    void evaluatesSubtractionOfSum() {
        // x - (y + 3)
        Expression expression = new SubtractExpression(
                new VariableExpression("x"),
                new AddExpression(new VariableExpression("y"), new NumberExpression(3)));

        assertEquals(2.0, expression.interpret(context));
    }

    @Test
    void sameTreeReinterpretsWithChangedContext() {
        Expression expression = new AddExpression(new VariableExpression("x"), new VariableExpression("y"));

        context.put("x", 20.0);
        assertEquals(25.0, expression.interpret(context));
    }

    @Test
    void unknownVariableEvaluatesToZero() {
        assertEquals(0.0, new VariableExpression("missing").interpret(context));
    }

    @Test
    void divisionByZeroThrows() {
        Expression expression = new DivideExpression(
                new VariableExpression("x"),
                new SubtractExpression(new VariableExpression("y"), new NumberExpression(5)));

        assertThrows(ArithmeticException.class, () -> expression.interpret(context));
    }
}
