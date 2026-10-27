package com.mattee37.patterns.behavioral.templatemethod;

public abstract class ReportGenerator {
    public void generate() {
        fetchData();
        processData();
        formatReport();
        export();
    }

    protected abstract void fetchData();

    protected abstract void processData();

    protected void formatReport() {
        System.out.println("   Formatting report...");
    }

    protected abstract void export();
}
