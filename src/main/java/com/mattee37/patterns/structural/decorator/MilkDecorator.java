package com.mattee37.patterns.structural.decorator;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.5;
    }

    @Override
    public String description() {
        return coffee.description() + " + Milk";
    }
}
