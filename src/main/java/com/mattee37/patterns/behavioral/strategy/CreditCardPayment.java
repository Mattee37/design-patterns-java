package com.mattee37.patterns.behavioral.strategy;

public class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(int amount) {
        System.out.println("💳 Paid $" + amount + " with credit card " + cardNumber);
    }
}
