package com.mattee37.patterns.structural.facade;

public class FacadeDemo {
    public static void main(String[] args) {
        System.out.println("=== Facade Pattern ===\n");

        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        homeTheater.watchMovie("The Matrix");
        homeTheater.endMovie();
    }
}
