package com.mattee37.patterns.creational.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LoggerSingletonTest {

    @Test
    void returnsSameInstance() {
        assertSame(Logger.getInstance(), Logger.getInstance());
    }

    @Test
    void logsMessages() {
        Logger logger = Logger.getInstance();
        int before = logger.getLogs().size();

        logger.log("test message");

        assertEquals(before + 1, logger.getLogs().size());
        assertTrue(logger.getLogs().get(logger.getLogs().size() - 1).contains("test message"));
    }

    @Test
    void getLogsReturnsDefensiveCopy() {
        java.util.List<String> logs = Logger.getInstance().getLogs();
        assertThrows(UnsupportedOperationException.class, logs::clear);
    }
}
