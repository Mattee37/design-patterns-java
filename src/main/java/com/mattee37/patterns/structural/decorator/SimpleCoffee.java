package com.mattee37.patterns.structural.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public double cost() {
        return 2;
    }

    @Override
    public String description() {
        return "Coffee";
    }
}
