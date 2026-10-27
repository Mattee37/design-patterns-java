package com.mattee37.patterns.structural.proxy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProxyTest {

    private static String capture(Runnable action) {
        PrintStream original = System.out;
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        System.setOut(new PrintStream(buffer, true, StandardCharsets.UTF_8));
        try {
            action.run();
        } finally {
            System.setOut(original);
        }
        return buffer.toString(StandardCharsets.UTF_8);
    }

    private static long countLines(String output, String needle) {
        return output.lines().filter(line -> line.contains(needle)).count();
    }

    @Test
    void proxyCreationDoesNotLoadImage() {
        String output = capture(() -> new ImageProxy("photo1.jpg"));

        assertEquals(1, countLines(output, "Proxy created for: photo1.jpg"));
        assertEquals(0, countLines(output, "Loading image"));
    }

    @Test
    void imageLoadsOnlyOnceAcrossDisplays() {
        ImageProxy proxy = new ImageProxy("photo2.jpg");

        String output = capture(() -> {
            proxy.display();
            proxy.display();
        });

        assertEquals(1, countLines(output, "Loading image: photo2.jpg"));
        assertEquals(2, countLines(output, "Displaying: photo2.jpg"));
    }
}
