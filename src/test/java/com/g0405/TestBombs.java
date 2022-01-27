package com.g0405;

import com.g0405.elements.components.Bombs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBombs {
    Bombs bomb;

    @BeforeEach
    public void bombsConstructor(){
        bomb = new Bombs(10,20,"g");
    }

    @Test
    public void testBombsConstructor(){
        assertEquals(10,bomb.getPosition().getX());
        assertEquals(20,bomb.getPosition().getY());
    }

    @Test
    public void testBombsSetIcon(){
        bomb.setIcon("d");
        assertEquals("d",bomb.getIcon());
    }

    @Test
    public void testBombsGetIcon(){
        assertEquals("g",bomb.getIcon());
    }
}
