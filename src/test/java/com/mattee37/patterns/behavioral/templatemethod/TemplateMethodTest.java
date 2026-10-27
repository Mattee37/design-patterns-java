package com.mattee37.patterns.behavioral.templatemethod;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TemplateMethodTest {

    private static String capture(Runnable action) {
        var buffer = new ByteArrayOutputStream();
        var original = System.out;
        try {
            System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString(StandardCharsets.UTF_8);
    }

    @Test
    void pdfRunsAllStepsInOrder() {
        var output = capture(() -> new PDFReport().generate());

        assertOrder(output, List.of(
                "Fetching data from database",
                "Processing data for PDF",
                "Formatting report",
                "Exporting as PDF"));
    }

    @Test
    void excelOverridesHookButKeepsStructure() {
        var output = capture(() -> new ExcelReport().generate());

        assertOrder(output, List.of(
                "Fetching data from API",
                "Processing data for Excel",
                "Formatting with Excel styles",
                "Exporting as Excel"));
        assertFalse(output.contains("Formatting report"));
    }

    private static void assertOrder(String output, List<String> steps) {
        int previous = -1;
        for (var step : steps) {
            int index = output.indexOf(step);
            assertTrue(index > previous, "missing or out of order: " + step);
            previous = index;
        }
    }
}
