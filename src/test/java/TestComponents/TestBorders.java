package TestComponents;
import Components.Borders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBorders {

    @BeforeEach
    public void bordersConstructor(){
        Borders borders = new Borders(10,20);
    }

    @Test
    public void testBordersConstructor(){

        assertEquals(10, borders.getPosition().getX());
        assertEquals(20, borders.getPosition().getY());

    }

    @Test
    public void testBordersSetPosition(){

        Borders borders1 = new Borders(20, 10);


        Mockito.verify(borders1.;)
        borders.setPosition(borders1.getPosition());

        assertEquals(20, borders.getPosition().getX());
        assertEquals(10, borders.getPosition().getY());
    }

}
