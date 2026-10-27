package com.mattee37.patterns.behavioral.interpreter;

import java.util.Map;

public record VariableExpression(String name) implements Expression {
    @Override
    public double interpret(Map<String, Double> context) {
        return context.getOrDefault(name, 0.0);
    }
}
