package com.mattee37.patterns.structural.adapter;

public class AudioPlayerAdapter implements MediaPlayer {
    private final LegacyAudioPlayer legacyPlayer;

    public AudioPlayerAdapter(LegacyAudioPlayer legacyPlayer) {
        this.legacyPlayer = legacyPlayer;
    }

    @Override
    public void play(String filename) {
        legacyPlayer.playMp3(filename);
    }
}
