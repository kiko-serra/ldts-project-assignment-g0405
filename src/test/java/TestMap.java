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

            public boolean comparePositions(Position pos1, Position pos2, int increX, int increY){
                int x = pos2.getX() + increX;
                int y = pos2.getY() + increY;
                Position posAux = new Position(x, y);
                return pos1.equals(posAux);
            }


            public boolean checkPosition (Components component, List<Biscuits> biscuits){
                for (int i=-1; i<3; i++){
                    if (comparePositions(component.getPosition(), princess.getPosition(), -2, i)) return false;
                    if (comparePositions(component.getPosition(), princess.getPosition(), -1, i)) return false;
                    if (comparePositions(component.getPosition(), princess.getPosition(), 0, i)) return false;
                    if (comparePositions(component.getPosition(), princess.getPosition(), +1, i)) return false;
                    if (comparePositions(component.getPosition(), princess.getPosition(), +2, i)) return false;
                }
                if(component.getPosition().equals(jack.getPosition())) return false;

                for(Biscuits biscuit : biscuits){
                    if(component.getPosition().equals(biscuit.getPosition())) return false;
                }
                return true;
            }

            
        }

        MapStub map = new MapStub(40,20);
    }
}
