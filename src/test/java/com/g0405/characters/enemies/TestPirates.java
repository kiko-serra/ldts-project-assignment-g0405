package com.g0405.characters.enemies;

import com.g0405.elements.components.characters.enemies.Pirates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPirates {
    Pirates pirate;

    @BeforeEach
    public void pirateConstructor(){

        pirate = new Pirates(10,20, "p", 'P');
    }

    @Test
    public void testPirateConstructor(){

        assertEquals(10, pirate.getPosition().getX());
        assertEquals(20, pirate.getPosition().getY());

    }
}
