package com.g0405_Tests.elements.components;

import com.g0405.elements.components.Exit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExit {
    Exit exit;

    @BeforeEach
    public void exitConstructor(){
        exit = new Exit(10,20);
    }

    @Test
    public void testExitConstructor(){
        assertEquals(10, exit.getPosition().getX());
        assertEquals(20, exit.getPosition().getY());
    }
}