package com.mattee37.patterns.structural.facade;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

class FacadeTest {

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

    @Test
    void watchMovieCoordinatesAllSubsystems() {
        String output = capture(() -> new HomeTheaterFacade().watchMovie("The Matrix"));

        assertTrue(output.contains("Lights dimmed to 10%"));
        assertTrue(output.contains("TV is ON"));
        assertTrue(output.contains("Sound system is ON"));
        assertTrue(output.contains("Volume set to 50"));
        assertTrue(output.contains("Streaming player is ON"));
        assertTrue(output.contains("Playing \"The Matrix\""));

        // Facade orchestrates in order: lights, tv, sound, player.
        int dim = output.indexOf("Lights dimmed");
        int tvOn = output.indexOf("TV is ON");
        int play = output.indexOf("Playing \"The Matrix\"");
        assertTrue(dim < tvOn && tvOn < play);
    }

    @Test
    void endMovieShutsDownInReverseOrder() {
        String output = capture(() -> new HomeTheaterFacade().endMovie());

        assertTrue(output.contains("Stopped playback"));
        assertTrue(output.contains("Streaming player is OFF"));
        assertTrue(output.contains("Sound system is OFF"));
        assertTrue(output.contains("TV is OFF"));
        assertTrue(output.contains("Lights are ON"));
    }
}
