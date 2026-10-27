package com.mattee37.patterns.behavioral.chainofresponsibility;

public class TechnicalSupport extends BaseHandler {
    @Override
    public void handle(SupportRequest request) {
        if (request.type() == SupportRequest.Type.TECHNICAL) {
            System.out.println("🔧 Technical Support: \"" + request.message() + "\"");
        } else {
            super.handle(request);
        }
    }
}
