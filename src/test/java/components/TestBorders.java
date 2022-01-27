package components;

import elements.Position;
import elements.components.Borders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBorders {

    Borders border1;

    @BeforeEach
    public void bordersConstructor(){
        border1 = new Borders(10,20);
    }

    @Test
    public void testBordersConstructor(){
        assertEquals(10, border1.getPosition().getX());
        assertEquals(20, border1.getPosition().getY());
    }

    @Test
    public void testBordersSetPosition(){
        border1.setPosition(new Position(20,10));

        assertEquals(20, this.border1.getPosition().getX());
        assertEquals(10, this.border1.getPosition().getY());
    }
}
