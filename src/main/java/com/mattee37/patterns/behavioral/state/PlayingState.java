package com.mattee37.patterns.behavioral.state;

class PlayingState implements State {
    @Override
    public void play(MusicPlayer player) {
        System.out.println("▶️  Already playing");
    }

    @Override
    public void pause(MusicPlayer player) {
        System.out.println("⏸️  Pausing");
        player.setState(new PausedState());
    }

    @Override
    public void stop(MusicPlayer player) {
        System.out.println("⏹️  Stopping");
        player.setState(new StoppedState());
    }
}
