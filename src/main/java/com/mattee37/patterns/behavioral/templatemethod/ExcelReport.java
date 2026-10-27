package com.mattee37.patterns.behavioral.templatemethod;

public class ExcelReport extends ReportGenerator {
    @Override
    protected void fetchData() {
        System.out.println("   Fetching data from API...");
    }

    @Override
    protected void processData() {
        System.out.println("   Processing data for Excel...");
    }

    @Override
    protected void formatReport() {
        System.out.println("   Formatting with Excel styles...");
    }

    @Override
    protected void export() {
        System.out.println("   Exporting as Excel 📊");
    }
}
