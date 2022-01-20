package components;

import elements.Points;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPoints {
    Points points;

    @BeforeEach
    public void pointsConstructor(){
        points = new Points(10,20,"abc");
    }

    @Test
    public void testPointsConstructor(){
        assertEquals(10,points.getPosition().getX());
        assertEquals(20,points.getPosition().getY());
    }
}