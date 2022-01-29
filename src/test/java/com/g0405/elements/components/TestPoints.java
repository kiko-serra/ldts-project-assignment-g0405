package com.g0405.elements.components;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPoints {
    Points points;
    TextGraphics tg;
    TextColor tc;

    @BeforeEach
    public void pointsConstructor(){

        points = new Points(10,20,"abc");
        tc = TextColor.Factory.fromString("#171717");
        tg = Mockito.mock(TextGraphics.class);
    }

    @Test
    public void testPointsConstructor(){
        assertEquals(10,points.getPosition().getX());
        assertEquals(20,points.getPosition().getY());
    }

    @Test
    public void testPointsDrawSetBackgroundColor(){
        points.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(tc);

    }
}