package com.mattee37.patterns.behavioral.strategy;

public class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("🅿️  Paid $" + amount + " via PayPal (" + email + ")");
    }
}
