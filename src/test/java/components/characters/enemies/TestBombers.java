package components.characters.enemies;

import elements.components.Bombs;
import elements.components.characters.enemies.Bombers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestBombers {
    Bombers bomber1;

    @BeforeEach
    public void bomberConstructor(){
        bomber1 = new Bombers(10,20,"m",'M',3);
    }

    @Test
    public void testBomberConstructor(){
        assertEquals(10,bomber1.getPosition().getX());
        assertEquals(20,bomber1.getPosition().getY());
        assertEquals("m",bomber1.getIcon());
        assertEquals('M',bomber1.getType());
    }

    @Test
    public void testBomberGetBomb(){
        bomber1.getBomb();
        assertNull(bomber1.getBomb());
    }

    @Test
    public void testBomberSetBombNull(){
        bomber1.getBomb();
        bomber1.setBombNull();
        assertEquals(null,bomber1.getBomb());
    }

    @Test
    public void testBomberSetCounter(){
        bomber1.setCounter(5);
        assertEquals(5,bomber1.getCounter());

    }

    @Test
    public void testBomberSetIcon(){
        bomber1.setIcon("l");
        assertEquals("l",bomber1.getIcon());
    }

    @Test
    public void testBomberGetType(){
        assertEquals('M',bomber1.getType());
    }
}