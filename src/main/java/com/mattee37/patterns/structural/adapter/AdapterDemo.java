package com.mattee37.patterns.structural.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("=== Adapter Pattern ===\n");

        LegacyAudioPlayer legacyPlayer = new OldMp3Player();
        MediaPlayer adapter = new AudioPlayerAdapter(legacyPlayer);

        System.out.println("Using the new MediaPlayer interface:");
        adapter.play("song.mp3");
        adapter.play("track.mp3");
    }
}
