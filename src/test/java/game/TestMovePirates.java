package game;

import elements.components.characters.enemies.Pirates;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMovePirates {

    Pirates pirate;
    Pirates pirate1;
    Pirates pirate2;
    Pirates pirate3;
    Pirates pirate4;

    @BeforeEach
    public void piratesConstructor(){
        pirate = new Pirates(10,20,null,'a');
        pirate1 = new Pirates(1, 20,null,'a');
        pirate2 = new Pirates(12, 4,null,'a');
        pirate3 = new Pirates(18, 4,null,'a');
        pirate4 = new Pirates(28, 4,null,'a');

    }

    @Test
    public void testMovePirate(){
        pirate.setState(0);
        pirate.move();
        assertEquals(11, pirate.getPosition().getX());

        pirate.setState(1);
        pirate.move();
        assertEquals(10, pirate.getPosition().getX());

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
