package com.mattee37.patterns.creational.factory;

public class Truck implements Vehicle {
    public String type() {
        return "Truck";
    }

    public int wheels() {
        return 6;
    }

    public void drive() {
        System.out.println("Driving a truck 🚛");
    }
}
