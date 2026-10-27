package com.mattee37.patterns.creational.builder;

public record Pizza(Size size, boolean cheese, boolean pepperoni, boolean mushrooms, boolean olives) {
    public enum Size { SMALL, MEDIUM, LARGE }
}
