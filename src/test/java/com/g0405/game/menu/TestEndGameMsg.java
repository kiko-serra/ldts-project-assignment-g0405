package com.g0405.game.menu;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g0405.game.EndGameMsg;
import com.g0405.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;
import java.io.IOException;

public class TestEndGameMsg {

    EndGameMsg endGameMsg;
    TextGraphics tg;
    TextColor tcb;

    @BeforeEach
    public void setUp() throws IOException, FontFormatException {
        endGameMsg = new EndGameMsg(new Game(30,30),"abcd");
        tcb = TextColor.Factory.fromString("#171717");
        tg = Mockito.mock(TextGraphics.class);
    }

    @Test
    public void testMenuDrawSetBackgroundColor(){
        endGameMsg.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(tcb);
    }


    @Test
    public void testMenuDrawSetFillRectangle(){
        endGameMsg.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).fillRectangle(new TerminalPosition(0, 0), new TerminalSize(30, 31),' ');
    }


    @Test
    public void testMenuDrawPutString(){
        endGameMsg.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(13,14),"abcd");
    }



}
