package com.mattee37.patterns.behavioral.state;

public class StateDemo {
    public static void main(String[] args) {
        System.out.println("=== State Pattern ===\n");

        AudioPlayer player = new AudioPlayer();

        player.play();
        player.play();
        player.pause();
        player.play();
        player.stop();
        player.pause();
        player.play();
    }
}
