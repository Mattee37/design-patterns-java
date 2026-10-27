package com.mattee37.patterns.behavioral.templatemethod;

public class TemplateMethodDemo {
    public static void main(String[] args) {
        System.out.println("=== Template Method Pattern ===\n");

        System.out.println("Generating PDF Report:");
        PDFReport pdfReport = new PDFReport();
        pdfReport.generate();

        System.out.println("\nGenerating Excel Report:");
        ExcelReport excelReport = new ExcelReport();
        excelReport.generate();
    }
}
