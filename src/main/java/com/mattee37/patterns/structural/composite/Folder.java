package com.mattee37.patterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public final class Folder implements FileSystemItem {
    private final String name;
    private final List<FileSystemItem> children = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return name;
    }

    public void add(FileSystemItem item) {
        children.add(item);
    }

    @Override
    public int getSize() {
        return children.stream().mapToInt(FileSystemItem::getSize).sum();
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "📁 " + name + " (" + getSize() + "KB)");
        children.forEach(child -> child.print(indent + "  "));
    }
}
