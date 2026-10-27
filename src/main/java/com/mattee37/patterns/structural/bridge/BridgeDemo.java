package com.mattee37.patterns.structural.bridge;

public class BridgeDemo {
    public static void main(String[] args) {
        System.out.println("=== Bridge Pattern ===\n");

        TV tv = new TV();
        RemoteControl tvRemote = new RemoteControl(tv);

        System.out.println("Controlling TV:");
        tvRemote.togglePower();
        tvRemote.volumeUp();
        tvRemote.volumeUp();
        tvRemote.togglePower();

        System.out.println("\nControlling Radio:");
        Radio radio = new Radio();
        RemoteControl radioRemote = new RemoteControl(radio);

        radioRemote.togglePower();
        radioRemote.volumeDown();
    }
}
