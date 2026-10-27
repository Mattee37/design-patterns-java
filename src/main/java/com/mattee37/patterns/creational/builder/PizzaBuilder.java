package com.mattee37.patterns.creational.builder;

public class PizzaBuilder {
    private Pizza.Size size = Pizza.Size.MEDIUM;
    private boolean cheese;
    private boolean pepperoni;
    private boolean mushrooms;
    private boolean olives;

    public PizzaBuilder setSize(Pizza.Size size) {
        this.size = size;
        return this;
    }

    public PizzaBuilder addCheese() {
        this.cheese = true;
        return this;
    }

    public PizzaBuilder addPepperoni() {
        this.pepperoni = true;
        return this;
    }

    public PizzaBuilder addMushrooms() {
        this.mushrooms = true;
        return this;
    }

    public PizzaBuilder addOlives() {
        this.olives = true;
        return this;
    }

    public Pizza build() {
        Pizza result = new Pizza(size, cheese, pepperoni, mushrooms, olives);
        reset();
        return result;
    }

    private void reset() {
        size = Pizza.Size.MEDIUM;
        cheese = pepperoni = mushrooms = olives = false;
    }
}
