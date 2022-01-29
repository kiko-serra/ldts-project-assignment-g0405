package com.g0405.elements.components.characters.enemies;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.g0405.elements.components.characters.enemies.Bombers;
import com.g0405.elements.components.characters.enemies.Enemies;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestEnemiesDraw {
    Enemies enemy;
    TextGraphics tg;
    TextColor tc;

    @BeforeEach
    public void setUp(){
        enemy = new Bombers(10,20,"m",'M',3);
        tc = TextColor.Factory.fromString("#6577B3");
        tg = Mockito.mock(TextGraphics.class);
    }

    @Test
    public void testEnemyDrawForegroundColor(){
        enemy.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(tc);
    }

    @Test
    public void testPirateDrawPutString(){
        enemy.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(10, 20),"m");
    }
}
