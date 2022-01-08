import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test_Components {

    @Test
    public void test_biscuits() {
        Biscuits biscuits = new Biscuits(10, 20);

        assertEquals(10, biscuits.getPosition().getX());
        assertEquals(20, biscuits.getPosition().getY());
    }

    @Test
    public void test_borders() {
        Borders borders = new Borders(10, 20);

        assertEquals(10, borders.getPosition().getX());
        assertEquals(20, borders.getPosition().getY());


        Borders borders1 = new Borders(20, 10);

        borders.setPosition(borders1.getPosition());

        assertEquals(20, borders.getPosition().getX());
        assertEquals(10, borders.getPosition().getY());
    }

    @Test
    public void test_jack_the_sparrow() {
        JackTheSparrow jack = new JackTheSparrow(10, 20);

        assertEquals(10, jack.getPosition().getX());
        assertEquals(20, jack.getPosition().getY());

        jack.setJackDirection(KeyType.ArrowDown);
        assertEquals(KeyType.ArrowDown, jack.getDirection());
        jack.setJackDirection(KeyType.ArrowUp);
        assertEquals(KeyType.ArrowUp, jack.getDirection());
        jack.setJackDirection(KeyType.ArrowLeft);
        assertEquals(KeyType.ArrowLeft, jack.getDirection());
        jack.setJackDirection(KeyType.ArrowRight);
        assertEquals(KeyType.ArrowRight, jack.getDirection());

        jack.setLives();
        jack.setLives();
        jack.setLives();

        assertEquals(true, jack.checkIfDead());

        jack.setPoints();

        assertEquals(1, jack.getPoints());

        JackTheSparrow jack1 = new JackTheSparrow(15, 20);

        jack1.setLives();
        assertEquals(false, jack1.checkIfDead());

        assertEquals(0, jack1.getPoints());
    }

    @Test
    public void test_key() {
        Key key = new Key(20, 20);
        assertEquals(20, key.getPosition().getX());
        assertEquals(20, key.getPosition().getY());

    }

    @Test
    public void test_pirates() {
        Pirates pirates = new Pirates(10, 20);

        assertEquals(10, pirates.getPosition().getX());
        assertEquals(20, pirates.getPosition().getY());

        //Falha na estrutura. Possível input que leva a erro


    }

    @Test
    public void test_princess() {
        Princess princess = new Princess(15, 20);


        assertEquals(15, princess.getPosition().getX());
        assertEquals(20, princess.getPosition().getY());

    }

}
