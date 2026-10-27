package com.mattee37.patterns.behavioral.strategy;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StrategyTest {

    private static String capture(Runnable action) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try {
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString(StandardCharsets.UTF_8);
    }

    @Test
    void checkoutDelegatesToSelectedStrategy() {
        ShoppingCart cart = new ShoppingCart();

        String output = capture(() -> {
            cart.setPaymentMethod(new CreditCardPayment("**** **** **** 1234"));
            cart.checkout(100);
            cart.setPaymentMethod(new PayPalPayment("user@example.com"));
            cart.checkout(50);
            cart.setPaymentMethod(new CryptoPayment("0x1234...abcd"));
            cart.checkout(200);
        });

        assertTrue(output.contains("Paid $100 with credit card **** **** **** 1234"));
        assertTrue(output.contains("Paid $50 via PayPal (user@example.com)"));
        assertTrue(output.contains("Paid $200 with crypto wallet 0x1234...abcd"));
    }

    @Test
    void strategyIsSwappableAtRuntime() {
        ShoppingCart cart = new ShoppingCart();

        String output = capture(() -> {
            cart.setPaymentMethod(new CreditCardPayment("1111"));
            cart.checkout(10);
            cart.setPaymentMethod(new CryptoPayment("0x1"));
            cart.checkout(20);
        });

        assertTrue(output.contains("with credit card 1111"));
        assertTrue(output.contains("with crypto wallet 0x1"));
    }

    @Test
    void checkoutWithoutStrategyPrintsError() {
        String output = capture(() -> new ShoppingCart().checkout(10));

        assertTrue(output.contains("No payment method selected"));
    }
}
