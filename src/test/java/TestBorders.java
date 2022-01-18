import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBorders {

    Borders border;
    Borders border1;

    @BeforeEach
    public void bordersConstructor(){
        border = Mockito.mock(Borders.class);
        border1 = new Borders(10,20);
    }

    @Test
    public void testBordersConstructor(){

        assertEquals(10, border1.getPosition().getX());
        assertEquals(20, border1.getPosition().getY());

    }

    @Test
    public void testBordersSetPosition(){

        border.setPosition(border1.getPosition());
        Mockito.verify(border).setPosition(border1.getPosition());

        assertEquals(10, this.border1.getPosition().getX());
        assertEquals(20, this.border1.getPosition().getY());


    }

}
