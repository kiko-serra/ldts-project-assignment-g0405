package com.g0405.game;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.awt.*;
import java.io.IOException;

public class TestGame {
    Game game;
    TextGraphics tg;
    TextColor tcb;

    @BeforeEach
    public void setUp() throws IOException, FontFormatException {
        game = new Game(30,30);
        tcb = TextColor.Factory.fromString("#171717");
        tg = Mockito.mock(TextGraphics.class);
    }

    /*@Test
    public void testGameDraw() throws IOException {
        game.draw();
    }

    @Test
    public void testGameSetGameIsOver() {
        game.setGameIsOver();
        assertTrue(game.getGameIsOver());
    }

    @Test
    public void testGameSetMenuChoice(){
        game.setMenuChoice(1);
        assertEquals(1,game.getMenuChoice());
    }

    @Test
    public void testGameGetWidth(){
        assertEquals(30, game.getWidth());
    }

    @Test
    public void testGameGetHeight(){
        assertEquals(30, game.getWidth());
    }*/
}
