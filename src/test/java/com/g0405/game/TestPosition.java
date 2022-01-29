package com.g0405.game;

import com.g0405.elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class TestPosition {
    Position position;
    Position position1;

    @BeforeEach
    public void positionConstructor(){
        position = Mockito.mock(Position.class);
        position1 = new Position(10,20);
    }

    @Test
    public void testGetPosition(){
        assertEquals(10,position1.getX());
        assertEquals(20,position1.getY());
    }

    @Test
    public void testSetPosition(){
        position.setX(15);
        position.setY(25);
        Mockito.verify(position).setX(15);
        Mockito.verify(position).setY(25);

        position.setX(20);
        position.setX(15);
        Mockito.verify(position,times(2)).setX(15);
        position.setY(20);
        position.setY(25);
        Mockito.verify(position,times(2)).setY(25);
    }

    @Test
    public void testPositionMoveUp(){
        Position position2 = position1.moveUp();
        assertEquals(19,position2.getY());
    }

    @Test
    public void testPositionMoveDown(){
        Position position3 = position1.moveDown();
        assertEquals(21,position3.getY());
    }

    @Test
    public void testPositionMoveLeft(){
        Position position4 = position1.moveLeft();
        assertEquals(9,position4.getX());

    }

    @Test
    public void testPositionMoveRight(){
        Position position5 = position1.moveRight();
        assertEquals(11,position5.getX());
    }

    @Test
    public void testPositionEquals(){
        Mockito.when(position.equals(new Position(position.getX(),position.getY()))).thenReturn(true);
        Mockito.when(position.equals(new Position(position.getX(),position.getY()+1))).thenReturn(false);

        assertTrue(position1.equals(new Position(10, 20)));
        assertFalse(position1.equals(new Position(11, 20)));

        assertFalse(position1.equals(null));
        assertFalse(position1.equals(null));
    }
}