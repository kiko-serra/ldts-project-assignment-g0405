package components.characters.enemies;

import elements.components.characters.enemies.Bombers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBombers {
    Bombers bomber;
    @BeforeEach
    public void bomberConstructor(){
        bomber = new Bombers(10,20, "m", 'M', 30);
    }

    @Test
    public void testBomberConstructor(){

        assertEquals(10, bomber.getPosition().getX());
        assertEquals(20, bomber.getPosition().getY());

    }

    /*@Test
    public void testSetCounter
    */
}
