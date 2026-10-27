package com.mattee37.patterns.creational.abstractfactory;

class DarkButton implements Button {
    public void render() {
        System.out.println("[Dark Button] ⬛");
    }
}

class DarkInput implements Input {
    public void render() {
        System.out.println("[Dark Input] ⬛ |_______|");
    }
}

public class DarkThemeFactory implements UIFactory {
    public Button createButton() {
        return new DarkButton();
    }

    public Input createInput() {
        return new DarkInput();
    }
}
