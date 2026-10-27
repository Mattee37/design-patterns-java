package com.mattee37.patterns.behavioral.interpreter;

import java.util.Map;

public record AddExpression(Expression left, Expression right) implements Expression {
    @Override
    public double interpret(Map<String, Double> context) {
        return left.interpret(context) + right.interpret(context);
    }
}
