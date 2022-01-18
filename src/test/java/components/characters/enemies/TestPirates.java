package components.characters.enemies;

import elements.components.characters.enemies.Pirates;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPirates {
    Pirates pirate;

    @BeforeEach
    public void pirateConstructor(){
        //pirate = new elements.components.components.characters.components.characters.enemies.Pirates(10,20);
    }

    @Test
    public void testPirateConstructor(){

        assertEquals(10, pirate.getPosition().getX());
        assertEquals(20, pirate.getPosition().getY());

    }
}
