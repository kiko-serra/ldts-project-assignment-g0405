package com.g0405.game.menu;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g0405.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestInstructions {
    Instructions inst;
    TextGraphics tg;
    TextColor tcb;
    TextColor tcf;

    @BeforeEach
    public void setUp() throws IOException, FontFormatException {
        inst = new Instructions(new Game(30,30));
        tcb = TextColor.Factory.fromString("#000000");
        tcf = TextColor.Factory.fromString("#FFFFFF");
        tg = Mockito.mock(TextGraphics.class);
    }

    /*@Test
    public void testInstConstructor(){
        assertEquals(30,inst.getGame().getWidth());
        assertEquals(30,inst.getGame().getHeight());
    }
    @Test
    public void testInstDraw(){
        inst.draw(tg);
        Mockito.verify(tg, Mockito.times(8 )).enableModifiers(SGR.BOLD);
    }*/
}
