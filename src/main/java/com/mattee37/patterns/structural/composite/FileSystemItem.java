package com.mattee37.patterns.structural.composite;

public sealed interface FileSystemItem permits File, Folder {
    String name();

    int getSize();

    void print(String indent);

    default void print() {
        print("");
    }
}
