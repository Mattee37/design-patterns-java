package com.mattee37.patterns.creational.prototype;

public class PrototypeDemo {
    public static void main(String[] args) {
        System.out.println("=== Prototype Pattern ===\n");

        Document template = new Document(
                "Contract Template",
                "This is a legal contract...",
                "Legal Team"
        );

        System.out.println("Original:");
        template.print();

        Document contract1 = template.clone();
        contract1.title = "Contract for John";
        contract1.content = "Agreement with John Doe...";

        Document contract2 = template.clone();
        contract2.title = "Contract for Jane";
        contract2.content = "Agreement with Jane Smith...";

        System.out.println("Cloned documents:");
        contract1.print();
        contract2.print();

        System.out.println("Original unchanged:");
        template.print();
    }
}
