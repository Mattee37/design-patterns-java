package com.mattee37.patterns.structural.bridge;

public class Radio implements Device {
    private boolean on = false;
    private int volume = 30;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("📻 Radio is ON");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("📻 Radio is OFF");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("📻 Radio volume: " + this.volume);
    }
}
