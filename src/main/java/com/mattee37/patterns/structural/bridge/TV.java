package com.mattee37.patterns.structural.bridge;

public class TV implements Device {
    private boolean on = false;
    private int volume = 50;

    @Override
    public boolean isEnabled() {
        return on;
    }

    @Override
    public void enable() {
        on = true;
        System.out.println("📺 TV is ON");
    }

    @Override
    public void disable() {
        on = false;
        System.out.println("📺 TV is OFF");
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = Math.max(0, Math.min(100, volume));
        System.out.println("📺 TV volume: " + this.volume);
    }
}
