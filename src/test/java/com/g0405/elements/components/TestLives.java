package com.g0405.elements.components;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g0405.elements.components.Lives;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLives {
    Lives live;
    TextGraphics tg;
    TextColor tcf;

    @BeforeEach
    public void livesConstructor(){

        live = new Lives(10,20);
        tcf = TextColor.Factory.fromString("#B00000");
        tg = Mockito.mock(TextGraphics.class);
    }

    @Test
    public void testLivesConstructor(){
        assertEquals(10,live.getPosition().getX());
        assertEquals(20,live.getPosition().getY());
    }

    @Test
    public void testLiveSetForegroundColor(){
        live.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(tcf);

    }

    @Test
    public void testLiveDrawPutString(){
        live.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(10, 20),"h");
    }
}
