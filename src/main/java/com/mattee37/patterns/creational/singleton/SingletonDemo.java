package com.mattee37.patterns.creational.singleton;

public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("=== Singleton Pattern ===\n");

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        System.out.println("Are both instances the same? " + (logger1 == logger2));
        System.out.println();

        logger1.log("First message from logger1");
        logger2.log("Second message from logger2");
        logger1.log("Third message from logger1");

        System.out.println("\nAll logs from logger2:");
        System.out.println(logger2.getLogs());
    }
}
