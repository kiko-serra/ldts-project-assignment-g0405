package components.characters;

import elements.components.characters.JackTheSparrow;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

public class TestJackTheSparrow {

    JackTheSparrow jack;
    JackTheSparrow jack1;

    @BeforeEach
    public void jackConstructor(){
        jack = Mockito.mock(JackTheSparrow.class);
        jack1 = new JackTheSparrow(10,20);
    }

    @Test
    public void testJackConstructor(){
        assertEquals(10, jack1.getPosition().getX());
        assertEquals(20, jack1.getPosition().getY());
    }


    @Test
    public void testJackDirection(){

        jack.setJackDirection(KeyType.ArrowDown);
        Mockito.verify(jack).setJackDirection(KeyType.ArrowDown);

        jack.setJackDirection(KeyType.ArrowUp);
        Mockito.verify(jack).setJackDirection(KeyType.ArrowUp);

        jack.setJackDirection(KeyType.ArrowLeft);
        Mockito.verify(jack).setJackDirection(KeyType.ArrowLeft);

        jack.setJackDirection(KeyType.ArrowRight);
        Mockito.verify(jack).setJackDirection(KeyType.ArrowRight);

        jack.setJackDirection(KeyType.ArrowDown);
        jack.setJackDirection(KeyType.ArrowDown);
        jack.setJackDirection(KeyType.ArrowDown);
        jack.setJackDirection(KeyType.ArrowDown);

        Mockito.verify(jack, times(5)).setJackDirection(KeyType.ArrowDown);


        jack1.setJackDirection(KeyType.ArrowDown);
        assertEquals(KeyType.ArrowDown, jack1.getDirection());
    }

    @Test
    public void testJackSetLives(){
        jack.setLives();
        Mockito.when(jack.checkIfDead()).thenReturn(false);
        jack.setLives();
        jack.setLives();
        Mockito.when(jack.checkIfDead()).thenReturn(true);

        assertEquals(false,jack1.checkIfDead());
        jack1.setLives();
        jack1.setLives();
        jack1.setLives();
        assertEquals(true,jack1.checkIfDead());
    }

    @Test
    public void testJackSetPoints(){
        Mockito.when(jack.getPoints()).thenReturn(0);
        jack.setPoints();
        jack.setPoints();
        Mockito.when(jack.getPoints()).thenReturn(2);

        assertEquals(0,jack1.getPoints());
        jack1.setPoints();
        jack1.setPoints();
        assertEquals(2,jack1.getPoints());
    }
}
