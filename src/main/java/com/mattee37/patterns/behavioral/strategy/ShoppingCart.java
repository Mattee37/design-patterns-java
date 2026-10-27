package com.mattee37.patterns.behavioral.strategy;

public class ShoppingCart {
    private PaymentStrategy strategy;

    public void setPaymentMethod(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void checkout(int amount) {
        if (strategy == null) {
            System.out.println("❌ No payment method selected");
            return;
        }
        strategy.pay(amount);
    }
}
