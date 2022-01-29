package com.g0405.elements.components;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBombs {
    Bombs bomb;
    TextGraphics tg;
    TextColor tcf;

    @BeforeEach
    public void bombsConstructor(){

        bomb = new Bombs(10,20,"g");
        tcf = TextColor.Factory.fromString("#EDD94C");
        tg = Mockito.mock(TextGraphics.class);
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

    @Test
    public void testBombSetForegroundColor(){
        bomb.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(tcf);

    }

    @Test
    public void testBombDrawPutString(){
        bomb.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(10, 20),"g");
    }
}
