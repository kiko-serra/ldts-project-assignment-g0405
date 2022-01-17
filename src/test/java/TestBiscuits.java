import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBiscuits {

    Biscuits biscuit;

    @BeforeEach
    public void biscuitsConstructor(){
        biscuit = new Biscuits(10, 20);
    }

    @Test
    public void testBiscuitsConstructor() {

        assertEquals(10, biscuit.getPosition().getX());
        assertEquals(20, biscuit.getPosition().getY());
    }

}
