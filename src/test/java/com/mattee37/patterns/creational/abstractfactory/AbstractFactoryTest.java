package com.mattee37.patterns.creational.abstractfactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class AbstractFactoryTest {

    @Test
    void darkFactoryCreatesDarkFamily() {
        UIFactory factory = new DarkThemeFactory();
        assertInstanceOf(DarkButton.class, factory.createButton());
        assertInstanceOf(DarkInput.class, factory.createInput());
    }

    @Test
    void lightFactoryCreatesLightFamily() {
        UIFactory factory = new LightThemeFactory();
        assertInstanceOf(LightButton.class, factory.createButton());
        assertInstanceOf(LightInput.class, factory.createInput());
    }
}
