import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.List;

public class TestMap {
    @Test
    public void testMap(){

        class MapStub extends Map {
            public MapStub(int width, int height) {
                super(width, height);
            }

            MapStub map = new MapStub(40, 20);
        }
    }
}
