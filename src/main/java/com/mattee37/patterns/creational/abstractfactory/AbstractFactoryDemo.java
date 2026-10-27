package com.mattee37.patterns.creational.abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        System.out.println("=== Abstract Factory Pattern ===\n");

        System.out.println("Dark Theme:");
        renderUI(new DarkThemeFactory());

        System.out.println("\nLight Theme:");
        renderUI(new LightThemeFactory());
    }

    private static void renderUI(UIFactory factory) {
        Button button = factory.createButton();
        Input input = factory.createInput();

        button.render();
        input.render();
    }
}
