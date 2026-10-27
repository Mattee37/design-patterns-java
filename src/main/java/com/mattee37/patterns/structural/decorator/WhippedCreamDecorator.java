package com.mattee37.patterns.structural.decorator;

public class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double cost() {
        return coffee.cost() + 0.75;
    }

    @Override
    public String description() {
        return coffee.description() + " + Whipped Cream";
    }
}
