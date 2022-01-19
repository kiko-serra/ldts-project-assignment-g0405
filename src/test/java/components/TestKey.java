package components;

import com.googlecode.lanterna.graphics.TextGraphics;
import elements.components.Key;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKey {

    Key key;
    Key key1;
    TextGraphics graphics;

    @BeforeEach
    public void keyConstructor(){

        key = Mockito.mock(Key.class);
        key1 = new Key(10,20);

        graphics = Mockito.mock(TextGraphics.class);
    }

    @Test
    public void testKeyConstructor(){

        assertEquals(10, key1.getPosition().getX());
        assertEquals(20, key1.getPosition().getY());

    }

    @Test
    public void testKeyDraw(){
        key.draw(graphics);
        Mockito.verify(key).draw(graphics);
    }
}
