package com.mattee37.patterns.behavioral.state;

public class AudioPlayer implements MusicPlayer {
    private State state = new StoppedState();

    @Override
    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void play() {
        state.play(this);
    }

    @Override
    public void pause() {
        state.pause(this);
    }

    @Override
    public void stop() {
        state.stop(this);
    }

    public State state() {
        return state;
    }
}
