package com.mattee37.patterns.structural.facade;

public class HomeTheaterFacade {
    private final TV tv = new TV();
    private final SoundSystem sound = new SoundSystem();
    private final StreamingPlayer player = new StreamingPlayer();
    private final Lights lights = new Lights();

    public void watchMovie(String movie) {
        System.out.println("🎥 Getting ready to watch a movie...\n");
        lights.dim(10);
        tv.on();
        sound.on();
        sound.setVolume(50);
        player.on();
        player.play(movie);
    }

    public void endMovie() {
        System.out.println("\n🎥 Shutting down the theater...\n");
        player.stop();
        player.off();
        sound.off();
        tv.off();
        lights.on();
    }
}
