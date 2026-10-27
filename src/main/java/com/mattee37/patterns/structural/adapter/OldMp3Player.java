package com.mattee37.patterns.structural.adapter;

public class OldMp3Player implements LegacyAudioPlayer {
    @Override
    public void playMp3(String filename) {
        System.out.println("🎵 [Legacy Player] Playing MP3: " + filename);
    }
}
