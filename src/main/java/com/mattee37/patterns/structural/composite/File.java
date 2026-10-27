package com.mattee37.patterns.structural.composite;

public record File(String name, int size) implements FileSystemItem {
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📄 " + name + " (" + size + "KB)");
    }
}
