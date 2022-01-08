import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class testMovements {

    @Test
    public void testMoveJackTheSparrow(){
        JackTheSparrow jack = new JackTheSparrow(10,20);

        jack.setJackDirection(KeyType.ArrowUp);
        jack.move();
        assertEquals(19,jack.getPosition().getY());

        jack.setJackDirection(KeyType.ArrowDown);
        jack.move();
        assertEquals(20,jack.getPosition().getY());

        jack.setJackDirection(KeyType.ArrowRight);
        jack.move();
        assertEquals(11,jack.getPosition().getX());

        jack.setJackDirection(KeyType.ArrowLeft);
        jack.move();
        assertEquals(10,jack.getPosition().getX());
    }

    @Test
    public void testMovePirates(){
        Pirates pirates = new Pirates(10, 20);

        pirates.setState(0);
        pirates.move();
        assertEquals(11, pirates.getPosition().getX());
        pirates.setState(1);
        pirates.move();
        assertEquals(10, pirates.getPosition().getX());


        Pirates pirates1 = new Pirates(1, 20);
        pirates1.setState(1);
        pirates1.canPirateMove(pirates1, 30);
        assertEquals(0, pirates1.getState());

        Pirates pirates4 = new Pirates(18, 4);
        pirates4.setState(1);
        pirates4.canPirateMove(pirates4, 30);
        assertEquals(0, pirates4.getState());

        Pirates pirates2 = new Pirates(28, 4);
        pirates2.setState(0);
        pirates2.canPirateMove(pirates2, 30);
        assertEquals(1, pirates2.getState());

        Pirates pirates3 = new Pirates(12, 4);
        pirates3.setState(0);
        pirates3.canPirateMove(pirates3, 30);
        assertEquals(1, pirates3.getState());
    }
}