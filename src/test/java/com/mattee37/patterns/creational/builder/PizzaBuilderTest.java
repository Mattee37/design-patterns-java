package com.mattee37.patterns.creational.builder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PizzaBuilderTest {

    @Test
    void buildsConfiguredPizza() {
        Pizza pizza = new PizzaBuilder()
                .setSize(Pizza.Size.LARGE)
                .addCheese()
                .addPepperoni()
                .build();

        assertEquals(Pizza.Size.LARGE, pizza.size());
        assertTrue(pizza.cheese());
        assertTrue(pizza.pepperoni());
        assertFalse(pizza.mushrooms());
        assertFalse(pizza.olives());
    }

    @Test
    void defaultsToMediumWithNoToppings() {
        Pizza pizza = new PizzaBuilder().build();

        assertEquals(Pizza.Size.MEDIUM, pizza.size());
        assertFalse(pizza.cheese());
        assertFalse(pizza.pepperoni());
        assertFalse(pizza.mushrooms());
        assertFalse(pizza.olives());
    }

    @Test
    void resetsAfterBuild() {
        PizzaBuilder builder = new PizzaBuilder().addCheese();
        builder.build();

        Pizza second = builder.build();

        assertFalse(second.cheese());
        assertEquals(Pizza.Size.MEDIUM, second.size());
    }
}
