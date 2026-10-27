package com.mattee37.patterns.behavioral.strategy;

public class CryptoPayment implements PaymentStrategy {
    private final String wallet;

    public CryptoPayment(String wallet) {
        this.wallet = wallet;
    }

    @Override
    public void pay(int amount) {
        System.out.println("₿  Paid $" + amount + " with crypto wallet " + wallet);
    }
}
