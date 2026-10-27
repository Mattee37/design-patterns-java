package com.mattee37.patterns.behavioral.state;

public interface MusicPlayer {
    void setState(State state);

    void play();

    void pause();

    void stop();
}
