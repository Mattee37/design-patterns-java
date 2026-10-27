package com.mattee37.patterns.behavioral.chainofresponsibility;

public class BasicSupport extends BaseHandler {
    @Override
    public void handle(SupportRequest request) {
        if (request.type() == SupportRequest.Type.BASIC) {
            System.out.println("📞 Basic Support: \"" + request.message() + "\"");
        } else {
            super.handle(request);
        }
    }
}
