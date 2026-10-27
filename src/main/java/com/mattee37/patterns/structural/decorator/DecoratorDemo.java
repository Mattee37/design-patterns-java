package com.mattee37.patterns.structural.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("=== Decorator Pattern ===\n");

        Coffee coffee = new SimpleCoffee();
        System.out.printf("☕ %s: $%.2f%n", coffee.description(), coffee.cost());

        coffee = new MilkDecorator(coffee);
        System.out.printf("☕ %s: $%.2f%n", coffee.description(), coffee.cost());

        coffee = new SugarDecorator(coffee);
        System.out.printf("☕ %s: $%.2f%n", coffee.description(), coffee.cost());

        coffee = new WhippedCreamDecorator(coffee);
        System.out.printf("☕ %s: $%.2f%n", coffee.description(), coffee.cost());

        System.out.println("\n--- Another order ---\n");

        Coffee latte = new WhippedCreamDecorator(
                new MilkDecorator(new MilkDecorator(new SimpleCoffee())));
        System.out.printf("☕ %s: $%.2f%n", latte.description(), latte.cost());
    }
}
