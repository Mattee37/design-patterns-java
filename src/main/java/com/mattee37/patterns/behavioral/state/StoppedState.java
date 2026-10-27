package com.mattee37.patterns.behavioral.state;

class StoppedState implements State {
    @Override
    public void play(MusicPlayer player) {
        System.out.println("▶️  Starting playback");
        player.setState(new PlayingState());
    }

    @Override
    public void pause(MusicPlayer player) {
        System.out.println("⏹️  Already stopped");
    }

    @Override
    public void stop(MusicPlayer player) {
        System.out.println("⏹️  Already stopped");
    }
}
