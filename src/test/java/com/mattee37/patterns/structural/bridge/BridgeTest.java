package com.mattee37.patterns.structural.bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BridgeTest {

    @Test
    void togglePowerTurnsDeviceOnAndOff() {
        TV tv = new TV();
        RemoteControl remote = new RemoteControl(tv);

        assertFalse(tv.isEnabled());
        remote.togglePower();
        assertTrue(tv.isEnabled());
        remote.togglePower();
        assertFalse(tv.isEnabled());
    }

    @Test
    void volumeIsClampedBetween0And100() {
        Radio radio = new Radio();
        RemoteControl remote = new RemoteControl(radio);

        for (int i = 0; i < 20; i++) {
            remote.volumeUp();
        }
        assertEquals(100, radio.getVolume());

        for (int i = 0; i < 20; i++) {
            remote.volumeDown();
        }
        assertEquals(0, radio.getVolume());
    }

    @Test
    void sameRemoteWorksWithDifferentDevices() {
        Radio radio = new Radio();
        RemoteControl remote = new RemoteControl(radio);

        remote.togglePower();
        remote.volumeDown();

        assertTrue(radio.isEnabled());
        assertEquals(20, radio.getVolume());
    }
}
