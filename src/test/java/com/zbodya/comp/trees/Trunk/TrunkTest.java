package com.zbodya.comp.trees.Trunk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class TrunkTest {
    @Test
    void testConstructor() {
        Trunk actualTrunk = new Trunk();
        assertNull(actualTrunk.getTrunkName());
        assertEquals("Trunk(trunk=null)", actualTrunk.toString());
    }

    @Test
    void testConstructor2() {
        Trunk actualTrunk = new Trunk("Trunk");
        assertEquals("Trunk", actualTrunk.getTrunkName());
        assertEquals("Trunk(trunk=Trunk)", actualTrunk.toString());
    }
}

