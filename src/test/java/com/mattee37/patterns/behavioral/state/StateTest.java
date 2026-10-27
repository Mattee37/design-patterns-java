package com.mattee37.patterns.behavioral.state;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StateTest {

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
    void transitionsBetweenStates() {
        var player = new AudioPlayer();
        assertInstanceOf(StoppedState.class, player.state());

        capture(() -> player.play());
        assertInstanceOf(PlayingState.class, player.state());

        capture(() -> player.pause());
        assertInstanceOf(PausedState.class, player.state());

        capture(() -> player.play());
        assertInstanceOf(PlayingState.class, player.state());

        capture(() -> player.stop());
        assertInstanceOf(StoppedState.class, player.state());
    }

    @Test
    void invalidTransitionsKeepCurrentStateAndPrintMessage() {
        var player = new AudioPlayer();

        var output = capture(() -> {
            player.pause();
            player.stop();
        });

        assertInstanceOf(StoppedState.class, player.state());
        assertTrue(output.contains("Already stopped"));
    }

    @Test
    void sequenceFromDemoMatchesExpectedMessages() {
        var player = new AudioPlayer();

        var output = capture(() -> {
            player.play();   // Stopped -> Playing
            player.play();   // already playing
            player.pause();  // Playing -> Paused
            player.play();   // Paused -> Playing
            player.stop();   // Playing -> Stopped
            player.pause();  // already stopped
            player.play();   // Stopped -> Playing
        });

        assertInstanceOf(PlayingState.class, player.state());
        assertTrue(output.contains("Starting playback"));
        assertTrue(output.contains("Already playing"));
        assertTrue(output.contains("Pausing"));
        assertTrue(output.contains("Resuming playback"));
        assertTrue(output.contains("Stopping"));
        assertTrue(output.contains("Already stopped"));
    }
}
