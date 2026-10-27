package com.mattee37.patterns.creational.singleton;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static Logger instance;
    private final List<String> logs = new ArrayList<>();

    private Logger() {
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        String entry = "[" + Instant.now() + "] " + message;
        logs.add(entry);
        System.out.println(entry);
    }

    public List<String> getLogs() {
        return List.copyOf(logs);
    }
}
