package components;

import com.googlecode.lanterna.graphics.TextGraphics;
import elements.components.Biscuits;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBiscuits {
    Biscuits biscuit;
    Biscuits biscuit1;

    TextGraphics graphics;

    @BeforeEach
    public void biscuitsConstructor(){
        biscuit = Mockito.mock(Biscuits.class);
        biscuit1 = new Biscuits(10, 20);
    }

    @Test
    public void testBiscuitsConstructor() {
        assertEquals(10, biscuit1.getPosition().getX());
        assertEquals(20, biscuit1.getPosition().getY());
    }


    @Test
    public void testBiscuitsDraw(){
        biscuit.draw(graphics);
        Mockito.verify(biscuit).draw(graphics);
    }
}
