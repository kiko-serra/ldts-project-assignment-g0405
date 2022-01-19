package game;

import elements.Position;
import elements.components.characters.Princess;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMovePrincess {

    Princess princess;

    @BeforeEach
    public void princessConstructor(){
        princess = new Princess(10,20);
    }

    @Test
    public void princessMove(){
        princess.setJackPosition(new Position(15,25));
        princess.move();

        assertEquals(15,princess.getPosition().getX());
        assertEquals(25,princess.getPosition().getY());
    }
}
