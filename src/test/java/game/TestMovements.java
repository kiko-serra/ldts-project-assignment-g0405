package game;

import elements.components.characters.JackTheSparrow;
import elements.components.characters.Princess;
import com.googlecode.lanterna.input.KeyType;
import elements.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMovements {

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

    /*@Test
    public void testMovePirates(){
        elements.components.components.characters.components.characters.enemies.Pirates pirates = new elements.components.components.characters.components.characters.enemies.Pirates(10, 20);

        pirates.setState(0);
        pirates.move();
        assertEquals(11, pirates.getPosition().getX());

        pirates.setState(1);
        pirates.move();
        assertEquals(10, pirates.getPosition().getX());


        elements.components.components.characters.components.characters.enemies.Pirates pirates1 = new elements.components.components.characters.components.characters.enemies.Pirates(1, 20);
        pirates1.setState(1);
        pirates1.canPirateMove(30);
        assertEquals(0, pirates1.getState());

        elements.components.components.characters.components.characters.enemies.Pirates pirates2 = new elements.components.components.characters.components.characters.enemies.Pirates(18, 4);
        pirates2.setState(1);
        pirates2.canPirateMove(30);
        assertEquals(0, pirates2.getState());

        elements.components.components.characters.components.characters.enemies.Pirates pirates3 = new elements.components.components.characters.components.characters.enemies.Pirates(12, 4);
        pirates3.setState(0);
        pirates3.canPirateMove(30);
        assertEquals(1, pirates3.getState());

        elements.components.components.characters.components.characters.enemies.Pirates pirates4 = new elements.components.components.characters.components.characters.enemies.Pirates(28, 4);
        pirates4.setState(0);
        pirates4.canPirateMove(30);
        assertEquals(1, pirates4.getState());
    }*/

    @Test
    public void testMovePosition(){
        Position position = new Position(15,25);

        assertEquals(15,position.getX());
        assertEquals(25,position.getY());

        position.setX(10);
        position.setY(20);
        assertEquals(10,position.getX());
        assertEquals(20,position.getY());

        Position position1 = position.moveUp();
        assertEquals(19,position1.getY());

        Position position2 = position.moveDown();
        assertEquals(21,position2.getY());

        Position position3 = position.moveLeft();
        assertEquals(9,position3.getX());

        Position position4 = position.moveRight();
        assertEquals(11,position4.getX());

        assertEquals(true, position.equals(new Position(10,20)));
        assertEquals(false, position.equals(new Position(11,20)));
    }

    @Test
    public void testMovePrincess(){
        Princess princess = new Princess(10,20);

        princess.setJackPosition(new Position(15,25));
        princess.move();

        assertEquals(15,princess.getPosition().getX());
        assertEquals(25,princess.getPosition().getY());
    }

}