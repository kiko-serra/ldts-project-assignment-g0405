package com.g0405.elements.components.characters.enemies;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPirates {
    Pirates pirate;
    TextGraphics tg;
    TextColor tc;

    @BeforeEach
    public void pirateConstructor(){
        pirate = new Pirates(10,20, "p", 'P');
        tc = TextColor.Factory.fromString("#B00000");
        tg = Mockito.mock(TextGraphics.class);
    }

    @Test
    public void testPirateConstructor(){
        assertEquals(10, pirate.getPosition().getX());
        assertEquals(20, pirate.getPosition().getY());
    }


    @Test
    public void testPirateDrawForegroundColor(){
        pirate.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(tc);
    }

    @Test
    public void testPirateDrawPutString(){
        pirate.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(10, 20),"p");
    }
}
