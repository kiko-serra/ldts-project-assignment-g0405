import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPrincess {

    Princess princess;
    Princess princess1;

    @BeforeEach
    public void princessConstructor(){
         princess  = Mockito.mock(Princess.class);
         princess1 = new Princess(10,20);
    }

    @Test
    public void testPrincessConstructor(){

        assertEquals(10, princess1.getPosition().getX());
        assertEquals(20, princess1.getPosition().getY());

    }

    @Test
    public void testPrincessSetJackPosition(){

        Position position = new Position(10,10);

        princess.setJackPosition(position);
        Mockito.verify(princess).setJackPosition(position);

    }


    @Test
    public void testPrincessGetJackPosition(){
        assertEquals(0,princess1.getJackPosition().getX());
        assertEquals(0,princess1.getJackPosition().getY());
    }
}
