package com.mattee37.patterns.structural.flyweight;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

class FlyweightTest {

    @Test
    void sameParametersShareOneInstance() {
        TreeType a = TreeFactory.getTreeType("Oak", "green", "rough");
        TreeType b = TreeFactory.getTreeType("Oak", "green", "rough");

        assertSame(a, b);
    }

    @Test
    void newTypeIncreasesCountRepeatedLookupDoesNot() {
        // honey: static factory cache shared across tests; assert relative deltas with unique keys
        int before = TreeFactory.getTypeCount();

        TreeType first = TreeFactory.getTreeType("Birch", "light-green", "papery");
        assertEquals(before + 1, TreeFactory.getTypeCount());

        TreeFactory.getTreeType("Birch", "light-green", "papery");
        assertEquals(before + 1, TreeFactory.getTypeCount());

        assertEquals("Birch", first.name());
    }
}
