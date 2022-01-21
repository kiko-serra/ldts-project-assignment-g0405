package components;

import com.googlecode.lanterna.graphics.TextGraphics;
import elements.components.Key;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKey {


    Key key1;

    @BeforeEach
    public void keyConstructor(){

        key1 = new Key(10,20);


    }

    @Test
    public void testKeyConstructor(){

        assertEquals(10, key1.getPosition().getX());
        assertEquals(20, key1.getPosition().getY());

    }


}
