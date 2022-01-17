import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBorders {

    Borders border;

    @BeforeEach
    public void bordersConstructor(){
        border = new Borders(10,20);
    }

    @Test
    public void testBordersConstructor(){

        assertEquals(10, border.getPosition().getX());
        assertEquals(20, border.getPosition().getY());

    }

    @Test
    public void testBordersSetPosition(){

        Borders border1 = new Borders(20, 10);


        //Mockito.verify(border)
        //border.setPosition(borders1.getPosition());

        assertEquals(20, border.getPosition().getX());
        assertEquals(10, border.getPosition().getY());
    }

}
