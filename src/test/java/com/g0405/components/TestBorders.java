package com.g0405.components;

import com.g0405.elements.components.Borders;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g0405.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBorders {

    Borders border1;
    TextGraphics tg;
    TextColor tcf;

    @BeforeEach
    public void bordersConstructor(){

        border1 = new Borders(10,20);
        tcf = TextColor.Factory.fromString("#B33F40");
        tg = Mockito.mock(TextGraphics.class);
    }

    @Test
    public void testBordersConstructor(){
        assertEquals(10, border1.getPosition().getX());
        assertEquals(20, border1.getPosition().getY());
    }

    @Test
    public void testBordersSetPosition(){
        border1.setPosition(new Position(20,10));

        assertEquals(20, this.border1.getPosition().getX());
        assertEquals(10, this.border1.getPosition().getY());
    }

    @Test
    public void testBorderSetForegroundColor(){
        border1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(tcf);

    }

    @Test
    public void testBorderDrawPutString(){
        border1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(10, 20),"b");
    }
}
