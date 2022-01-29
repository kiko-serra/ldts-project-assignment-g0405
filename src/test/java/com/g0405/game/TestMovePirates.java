package com.g0405.game;

import com.g0405.elements.components.characters.enemies.Pirates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMovePirates {

    Pirates pirate;
    Pirates pirate1;
    Pirates pirate2;
    Pirates pirate3;
    Pirates pirate4;

    @BeforeEach
    public void piratesConstructor(){
        pirate = new Pirates(10,20,"p",'P');
        pirate1 = new Pirates(1, 20,"p",'P');
        pirate2 = new Pirates(12, 4,"p",'P');
        pirate3 = new Pirates(18, 4,"p",'P');
        pirate4 = new Pirates(28, 4,"p",'P');

    }

    @Test
    public void testMovePirate(){
        pirate.setState(0);
        pirate.move();
        assertEquals(11, pirate.getPosition().getX());
        assertEquals("p", pirate.getIcon());

        pirate.setState(1);
        pirate.move();
        assertEquals(10, pirate.getPosition().getX());
        assertEquals("q", pirate.getIcon());
    }

    @Test
    public void testMovePirate1LeftMost(){
        pirate1.setState(1);
        pirate1.canEnemyMove(30);
        assertEquals(0, pirate1.getState());

    }

    @Test
    public void testMovePirate3LeftMid(){
        pirate2.setState(0);
        pirate2.canEnemyMove(30);
        assertEquals(1, pirate2.getState());

    }

    @Test
    public void testMovePirate2RightMid(){
        pirate3.setState(1);
        pirate3.canEnemyMove(30);
        assertEquals(0, pirate3.getState());

    }

    @Test
    public void testMovePirate4RightMost(){
        pirate4.setState(0);
        pirate4.canEnemyMove(30);
        assertEquals(1, pirate4.getState());
    }
}