package com.mattee37.patterns.structural.decorator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecoratorTest {

    @Test
    void decoratorsAddCumulativelyToCost() {
        Coffee coffee = new SimpleCoffee();
        assertEquals(2.0, coffee.cost(), 0.0001);

        coffee = new MilkDecorator(coffee);
        assertEquals(2.5, coffee.cost(), 0.0001);

        coffee = new SugarDecorator(coffee);
        assertEquals(2.75, coffee.cost(), 0.0001);

        coffee = new WhippedCreamDecorator(coffee);
        assertEquals(3.5, coffee.cost(), 0.0001);
    }

    @Test
    void decoratorsChainDescriptions() {
        Coffee latte = new WhippedCreamDecorator(
                new MilkDecorator(new MilkDecorator(new SimpleCoffee())));

        assertEquals("Coffee + Milk + Milk + Whipped Cream", latte.description());
        assertEquals(3.75, latte.cost(), 0.0001);
    }
}
