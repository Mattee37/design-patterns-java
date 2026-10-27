package com.mattee37.patterns.behavioral.interpreter;

import java.util.HashMap;
import java.util.Map;

public class InterpreterDemo {
    public static void main(String[] args) {
        System.out.println("=== Interpreter Pattern ===\n");

        Map<String, Double> context = new HashMap<>(Map.of("x", 10.0, "y", 5.0));

        // Expression: (x + y) * 2
        Expression expression = new MultiplyExpression(
                new AddExpression(new VariableExpression("x"), new VariableExpression("y")),
                new NumberExpression(2));

        System.out.println("Variables: x = 10, y = 5");
        System.out.println("Expression: (x + y) * 2");
        System.out.println("Result: " + fmt(expression.interpret(context)));

        // Expression: x - (y + 3)
        Expression expression2 = new SubtractExpression(
                new VariableExpression("x"),
                new AddExpression(new VariableExpression("y"), new NumberExpression(3)));

        System.out.println("\nExpression: x - (y + 3)");
        System.out.println("Result: " + fmt(expression2.interpret(context)));

        // Change context
        context.put("x", 20.0);
        System.out.println("\nAfter x = 20:");
        System.out.println("(x + y) * 2 = " + fmt(expression.interpret(context)));
        System.out.println("x - (y + 3) = " + fmt(expression2.interpret(context)));
    }

    // honey: whole numbers print without trailing ".0" to match the TS number output
    private static String fmt(double value) {
        return value % 1 == 0 ? String.valueOf((long) value) : String.valueOf(value);
    }
}
