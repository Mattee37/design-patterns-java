package com.mattee37.patterns.behavioral.chainofresponsibility;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChainOfResponsibilityTest {

    private static String capture(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString(StandardCharsets.UTF_8).strip();
    }

    private static SupportRequest request(SupportRequest.Type type) {
        return new SupportRequest(type, "msg");
    }

    @Test
    void eachRequestIsHandledByMatchingHandler() {
        BasicSupport basic = new BasicSupport();
        TechnicalSupport technical = new TechnicalSupport();
        BillingSupport billing = new BillingSupport();
        basic.setNext(technical).setNext(billing);

        assertEquals("📞 Basic Support: \"msg\"", capture(() -> basic.handle(request(SupportRequest.Type.BASIC))));
        assertEquals("🔧 Technical Support: \"msg\"", capture(() -> basic.handle(request(SupportRequest.Type.TECHNICAL))));
        assertEquals("💰 Billing Support: \"msg\"", capture(() -> basic.handle(request(SupportRequest.Type.BILLING))));
    }

    @Test
    void unhandledRequestReachesEndOfChain() {
        // TECHNICAL request with no next handler at all
        BasicSupport basic = new BasicSupport();

        assertEquals("❌ No handler available for this request",
                capture(() -> basic.handle(request(SupportRequest.Type.TECHNICAL))));
    }

    @Test
    void setNextReturnsTheLinkedHandler() {
        BasicSupport basic = new BasicSupport();
        TechnicalSupport technical = new TechnicalSupport();

        assertEquals(technical, basic.setNext(technical));
    }
}
