package com.mattee37.patterns.behavioral.chainofresponsibility;

public class BillingSupport extends BaseHandler {
    @Override
    public void handle(SupportRequest request) {
        if (request.type() == SupportRequest.Type.BILLING) {
            System.out.println("💰 Billing Support: \"" + request.message() + "\"");
        } else {
            super.handle(request);
        }
    }
}
