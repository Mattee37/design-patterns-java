package com.mattee37.patterns.creational.factory;

public class Motorcycle implements Vehicle {
    public String type() {
        return "Motorcycle";
    }

    public int wheels() {
        return 2;
    }

    public void drive() {
        System.out.println("Riding a motorcycle 🏍️");
    }
}
