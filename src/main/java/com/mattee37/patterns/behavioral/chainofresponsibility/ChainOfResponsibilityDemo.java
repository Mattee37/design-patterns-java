package com.mattee37.patterns.behavioral.chainofresponsibility;

import java.util.List;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        System.out.println("=== Chain of Responsibility Pattern ===\n");

        var basic = new BasicSupport();
        var technical = new TechnicalSupport();
        var billing = new BillingSupport();

        basic.setNext(technical).setNext(billing);

        var requests = List.of(
                new SupportRequest(SupportRequest.Type.BASIC, "How do I reset my password?"),
                new SupportRequest(SupportRequest.Type.TECHNICAL, "App crashes on startup"),
                new SupportRequest(SupportRequest.Type.BILLING, "Refund request"));

        requests.forEach(basic::handle);
    }
}
