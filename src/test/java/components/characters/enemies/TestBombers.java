package components.characters.enemies;

import elements.components.characters.enemies.Bombers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBombers {

    Bombers bomber;
    Bombers bomber1;

    @BeforeEach
    public void bomberConstructor(){
        bomber = Mockito.mock(Bombers.class);
        bomber1 = new Bombers(10,20,null,'a',3);
    }

    @Test
    public void testBomberConstructor(){

        assertEquals(10,bomber1.getPosition().getX());
        assertEquals(20,bomber1.getPosition().getY());
        assertEquals(null,bomber1.getIcon());
        assertEquals('a',bomber1.getType());

    }

    @Test
    public void testBomberBombActions(){

        bomber.bombActions();
        Mockito.verify(bomber).bombActions();
    }

    @Test
    public void testBomberGetBomb(){
        bomber.getBomb();
        Mockito.verify(bomber).getBomb();
    }

    @Test
    public void testBomberSetBombNull(){
        bomber.setBombNull();
        Mockito.verify(bomber).setBombNull();

        bomber1.getBomb();
        bomber1.setBombNull();
        assertEquals(null,bomber1.getBomb());
    }

    @Test
    public void testBomberCheckBomb(){
        bomber.checkBomb();
        Mockito.verify(bomber).checkBomb();
    }

    @Test
    public void testBomberCreateBombPosition(){
        bomber.createBombPosition();
        Mockito.verify(bomber).createBombPosition();
    }


    @Test
    public void testBomberSetCounter(){
        bomber1.setCounter(5);
        assertEquals(5,bomber1.getCounter());

        bomber.setCounter(5);
        bomber.setCounter(3);
        bomber.setCounter(2);
        bomber.setCounter(6);
        Mockito.verify(bomber).setCounter(6);
    }
}
