package com.mattee37.patterns.structural.facade;

// Package-private subsystem classes, mirroring the TS subsystems module.
class TV {
    void on() {
        System.out.println("📺 TV is ON");
    }

    void off() {
        System.out.println("📺 TV is OFF");
    }
}

class SoundSystem {
    void on() {
        System.out.println("🔊 Sound system is ON");
    }

    void off() {
        System.out.println("🔊 Sound system is OFF");
    }

    void setVolume(int level) {
        System.out.println("🔊 Volume set to " + level);
    }
}

class StreamingPlayer {
    void on() {
        System.out.println("🎬 Streaming player is ON");
    }

    void off() {
        System.out.println("🎬 Streaming player is OFF");
    }

    void play(String movie) {
        System.out.println("🎬 Playing \"" + movie + "\"");
    }

    void stop() {
        System.out.println("🎬 Stopped playback");
    }
}

class Lights {
    void dim(int level) {
        System.out.println("💡 Lights dimmed to " + level + "%");
    }

    void on() {
        System.out.println("💡 Lights are ON");
    }
}
