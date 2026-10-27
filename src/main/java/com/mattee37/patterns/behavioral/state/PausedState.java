package com.mattee37.patterns.behavioral.state;

class PausedState implements State {
    @Override
    public void play(MusicPlayer player) {
        System.out.println("▶️  Resuming playback");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MusicPlayer player) {
        System.out.println("⏸️  Already paused");
    }

    @Override
    public void stop(MusicPlayer player) {
        System.out.println("⏹️  Stopping");
        player.setState(new StoppedState());
    }
}
