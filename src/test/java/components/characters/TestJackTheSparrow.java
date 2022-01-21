package components.characters;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import elements.Position;
import elements.components.characters.JackTheSparrow;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

public class TestJackTheSparrow {

    JackTheSparrow jack;
    JackTheSparrow jack1;
    TextGraphics tg;
    TextColor tc;

    @BeforeEach
    public void jackConstructor(){
        jack = Mockito.mock(JackTheSparrow.class);
        jack1 = new JackTheSparrow(10,20);
        tc = TextColor.Factory.fromString("#171717");
        tg = Mockito.mock(TextGraphics.class);
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

        assertFalse(jack1.checkIfDead());
        jack1.setLives();
        jack1.setLives();
        jack1.setLives();
        assertTrue(jack1.checkIfDead());
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

    @Test
    public void testJackDrawSetBackgroundColor(){
        jack1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).setBackgroundColor(tc);

    }

    @Test
    public void testJackDrawPutString(){
        jack1.draw(tg);
        Mockito.verify(tg, Mockito.times(1)).putString(new TerminalPosition(10, 20),"j");
    }
}
