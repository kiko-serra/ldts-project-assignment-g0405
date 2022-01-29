package com.g0405_Tests.game.menu;

import com.g0405.game.menu.Menu;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g0405.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.io.IOException;

public class TestMenu {
    com.g0405.game.menu.Menu menu;
    TextGraphics tg;
    TextColor tcb;

    @BeforeEach
    public void setUp() throws IOException, FontFormatException {
        menu = new Menu(new Game(30,30));
        tcb = TextColor.Factory.fromString("#171717");
        tg = Mockito.mock(TextGraphics.class);
    }


    @Test
    public void testMenuSetBackgroundColor(){
        menu.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(tcb);
    }


    @Test
    public void testMenuSetFillRectangle(){
        menu.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 31),' ');
    }


    @Test
    public void testMenuSetSelector(){
        menu.setSelector(1);
        assertEquals(1,menu.getSelector());
    }

}
