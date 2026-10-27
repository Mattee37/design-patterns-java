package com.mattee37.patterns.behavioral.strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("=== Strategy Pattern ===\n");

        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentMethod(new CreditCardPayment("**** **** **** 1234"));
        cart.checkout(100);

        cart.setPaymentMethod(new PayPalPayment("user@example.com"));
        cart.checkout(50);

        cart.setPaymentMethod(new CryptoPayment("0x1234...abcd"));
        cart.checkout(200);
    }
}
