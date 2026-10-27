package com.mattee37.patterns.behavioral.interpreter;

import java.util.Map;

public record NumberExpression(double value) implements Expression {
    @Override
    public double interpret(Map<String, Double> context) {
        return value;
    }
}
