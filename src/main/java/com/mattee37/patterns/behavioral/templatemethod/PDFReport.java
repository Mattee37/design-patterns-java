package com.mattee37.patterns.behavioral.templatemethod;

public class PDFReport extends ReportGenerator {
    @Override
    protected void fetchData() {
        System.out.println("   Fetching data from database...");
    }

    @Override
    protected void processData() {
        System.out.println("   Processing data for PDF...");
    }

    @Override
    protected void export() {
        System.out.println("   Exporting as PDF 📄");
    }
}
