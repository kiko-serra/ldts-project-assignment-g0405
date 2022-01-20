package components;

import elements.Lives;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLives {
    Lives live;

    @BeforeEach
    public void livesConstructor(){
        live = new Lives(10,20);
    }

    @Test
    public void testLivesConstructor(){
        assertEquals(10,live.getPosition().getX());
        assertEquals(20,live.getPosition().getY());
    }
}
