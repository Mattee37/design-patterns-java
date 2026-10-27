package com.mattee37.patterns.behavioral.interpreter;

import java.util.Map;

public record DivideExpression(Expression left, Expression right) implements Expression {
    @Override
    public double interpret(Map<String, Double> context) {
        double divisor = right.interpret(context);
        if (divisor == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return left.interpret(context) / divisor;
    }
}
