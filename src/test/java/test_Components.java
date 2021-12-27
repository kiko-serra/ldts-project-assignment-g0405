import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test_Components {

    @Test
    public void test_borders(){
        Borders borders = new Borders(10,20);

        assertEquals(10,borders.getPosition().getX());
        assertEquals(20,borders.getPosition().getY());


        Borders borders1 = new Borders(20,10);

        borders.setPosition(borders1.getPosition());

        assertEquals(20,borders.getPosition().getX());
        assertEquals(10,borders.getPosition().getY());

    }

    @Test
    public void test_jack_the_sparrow(){
        Jack_The_Sparrow jack = new Jack_The_Sparrow(10,20);

        assertEquals(10,jack.getPosition().getX());
        assertEquals(20,jack.getPosition().getY());
    }

    @Test
    public void test_princess(){
        Princess princess = new Princess(15,20);
        assertEquals(15,princess.getPosition().getX());
        assertEquals(20,princess.getPosition().getY());

    }

    @Test
    public void test_map(){
        Map map = new Map(20,20);
        //waiting for public access on current implementations
    }
}
