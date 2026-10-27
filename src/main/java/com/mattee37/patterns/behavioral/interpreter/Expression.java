package com.mattee37.patterns.behavioral.interpreter;

import java.util.Map;

public interface Expression {
    double interpret(Map<String, Double> context);
}
