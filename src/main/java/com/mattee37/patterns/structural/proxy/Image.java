package com.mattee37.patterns.structural.proxy;

public interface Image {
    void display();
}

class RealImage implements Image {
    private final String filename;

    RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("⏳ Loading image: " + filename);
    }

    @Override
    public void display() {
        System.out.println("🖼️ Displaying: " + filename);
    }
}
