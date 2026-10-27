package com.mattee37.patterns.creational.factory;

public class Car implements Vehicle {
    public String type() {
        return "Car";
    }

    public int wheels() {
        return 4;
    }

    public void drive() {
        System.out.println("Driving a car 🚗");
    }
}
