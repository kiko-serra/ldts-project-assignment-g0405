import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestKey {

    Key key;

    @BeforeEach
    public void keyConstructor(){
        key = new Key(10,20);
    }

    @Test
    public void testKeyConstructor(){

        assertEquals(10, key.getPosition().getX());
        assertEquals(20, key.getPosition().getY());

    }
}
