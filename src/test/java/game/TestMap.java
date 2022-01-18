package game;

import org.junit.jupiter.api.Test;

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
