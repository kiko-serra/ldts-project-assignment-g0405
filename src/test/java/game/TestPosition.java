package game;

import elements.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestPosition {

    Position position;
    Position position1;

    @BeforeEach
    public void positionConstructor(){
        position = Mockito.mock(Position.class);
        position1 = new Position(10,20);
    }

    @Test
    public void testGetPosition(){
        //Mockito.when(position.getX()).thenReturn(position.)
    }
}
