package com.g0405_Tests.elements.components;

import com.g0405.elements.components.Biscuits;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBiscuits {
    Biscuits biscuit1;
    TextGraphics tg;
    TextColor tcb;
    TextColor tcf;


    @BeforeEach
    public void biscuitsConstructor(){

        biscuit1 = new Biscuits(10, 20);
        tcb = TextColor.Factory.fromString("#171717");
        tcf = TextColor.Factory.fromString("#E6CEA0");
        tg = Mockito.mock(TextGraphics.class);
    }

    @Test
    public void testBiscuitsConstructor() {
        assertEquals(10, biscuit1.getPosition().getX());
        assertEquals(20, biscuit1.getPosition().getY());

    }


    @Test
    public void testBiscuitSetBackgroundColor(){
        biscuit1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(tcb);

    }

    @Test
    public void testBiscuitSetForegroundColor(){
        biscuit1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(tcf);

    }

    @Test
    public void testBiscuitDrawPutString(){
        biscuit1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(10, 20),"c");
    }
}
