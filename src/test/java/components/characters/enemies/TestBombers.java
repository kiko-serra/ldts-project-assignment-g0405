package components.characters.enemies;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import elements.components.Bombs;
import elements.components.characters.enemies.Bombers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

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


    @Test
    public void testBomberCheckActionsCheckBomb(){
        bomber1.getBombPos().setX(10);
        bomber1.getBombPos().setY(20);

        bomber1.bombActions();

        assertEquals(bomber1.getBomb().getPosition().getX(),bomber1.getPosition().getX());
        assertEquals(bomber1.getBomb().getPosition().getY(),bomber1.getPosition().getY());
    }


    @Test
    public void testBomberCheckActionsSetIcon(){
        bomber1.getBombPos().setX(10);
        bomber1.getBombPos().setY(20);
        bomber1.setCounter(9);

        bomber1.bombActions();

        assertEquals("g",bomber1.getBomb().getIcon());

    }


    @Test
    public void testBomberCheckActionsSetBombNull(){
        bomber1.getBombPos().setX(10);
        bomber1.getBombPos().setY(20);
        bomber1.setCounter(13);

        bomber1.bombActions();

        assertNull(bomber1.getBomb());
    }


    @Test
    public void testBomberCheckActionsSetCounter(){
        bomber1.getBombPos().setX(10);
        bomber1.getBombPos().setY(20);
        bomber1.setCounter(13);

        bomber1.bombActions();

        assertEquals(0,bomber1.getCounter());
    }


    @Test
    public void testBomberCheckActionsCreateBombPos(){
        bomber1.getBombPos().setX(10);
        bomber1.getBombPos().setY(20);
        bomber1.setCounter(13);

        bomber1.bombActions();

        assertNotNull(bomber1.getBombPos());
    }


    @Test
    public void testBomberSetBomb(){
        bomber1.setBomb(new Bombs(10,10,"g"));

        assertEquals(10,bomber1.getBomb().getPosition().getX());
        assertEquals(10,bomber1.getBomb().getPosition().getY());
        assertEquals("g",bomber1.getBomb().getIcon());
    }




}