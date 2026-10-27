package com.mattee37.patterns.behavioral.state;

public interface State {
    void play(MusicPlayer player);

    void pause(MusicPlayer player);

    void stop(MusicPlayer player);
}
