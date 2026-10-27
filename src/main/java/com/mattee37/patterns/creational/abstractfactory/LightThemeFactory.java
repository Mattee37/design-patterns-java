package com.mattee37.patterns.creational.abstractfactory;

class LightButton implements Button {
    public void render() {
        System.out.println("[Light Button] ⬜");
    }
}

class LightInput implements Input {
    public void render() {
        System.out.println("[Light Input] ⬜ |_______|");
    }
}

public class LightThemeFactory implements UIFactory {
    public Button createButton() {
        return new LightButton();
    }

    public Input createInput() {
        return new LightInput();
    }
}
