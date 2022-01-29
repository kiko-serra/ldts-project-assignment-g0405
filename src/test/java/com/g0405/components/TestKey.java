package com.g0405.components;

import com.g0405.elements.components.Key;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKey {


    Key key1;
    TextGraphics tg;
    TextColor tcf;

    @BeforeEach
    public void keyConstructor(){

        key1 = new Key(10,20);
        tcf = TextColor.Factory.fromString("#ffffff");
        tg = Mockito.mock(TextGraphics.class);

    }

    @Test
    public void testKeyConstructor(){

        assertEquals(10, key1.getPosition().getX());
        assertEquals(20, key1.getPosition().getY());

    }

    @Test
    public void testKeySetForegroundColor(){
        key1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(tcf);

    }

    @Test
    public void testKeyDrawPutString(){
        key1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(10, 20),"k");
    }

}
