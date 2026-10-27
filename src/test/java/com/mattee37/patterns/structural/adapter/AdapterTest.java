package com.mattee37.patterns.structural.adapter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AdapterTest {

    private static final class RecordingLegacyPlayer implements LegacyAudioPlayer {
        final List<String> played = new ArrayList<>();

        @Override
        public void playMp3(String filename) {
            played.add(filename);
        }
    }

    @Test
    void adapterDelegatesToLegacyPlayer() {
        RecordingLegacyPlayer legacy = new RecordingLegacyPlayer();
        MediaPlayer adapter = new AudioPlayerAdapter(legacy);

        adapter.play("song.mp3");
        adapter.play("track.mp3");

        assertEquals(List.of("song.mp3", "track.mp3"), legacy.played);
    }
}
