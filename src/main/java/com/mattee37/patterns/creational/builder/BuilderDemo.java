package com.mattee37.patterns.creational.builder;

public class BuilderDemo {
    public static void main(String[] args) {
        System.out.println("=== Builder Pattern ===\n");

        PizzaBuilder builder = new PizzaBuilder();

        Pizza margherita = builder.setSize(Pizza.Size.MEDIUM).addCheese().build();

        System.out.println("Margherita: " + margherita);

        Pizza supreme = builder
                .setSize(Pizza.Size.LARGE)
                .addCheese()
                .addPepperoni()
                .addMushrooms()
                .addOlives()
                .build();

        System.out.println("Supreme: " + supreme);

        Pizza small = builder.setSize(Pizza.Size.SMALL).addCheese().addPepperoni().build();

        System.out.println("Small Pepperoni: " + small);
    }
}
