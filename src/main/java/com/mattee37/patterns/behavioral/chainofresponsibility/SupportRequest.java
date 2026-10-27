package com.mattee37.patterns.behavioral.chainofresponsibility;

public record SupportRequest(Type type, String message) {
    public enum Type { BASIC, TECHNICAL, BILLING }
}
