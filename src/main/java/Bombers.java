import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;

public class Bombers extends Enemies{
    private Position position;
    private final int width;
    private int counter;

    public Bombers(int x, int y, String icon, char type, int width) {
        super(x, y, icon, type);
        this.width = width;
        this.counter = 0;

        this.position = new Position(new Random().nextInt(width) + 1, super.getPosition().getY());
    }

    public boolean checkBomb(){
        if(super.getPosition().equals(position)){
            System.out.println("bomba");
            return true;
        }
        return false;
    }

    public Position getBombPosition() {
        return position;
    }

    public void createOtherBombPosition(){
        position = new Position(new Random().nextInt(width) + 1, super.getPosition().getY());
    }

    public void setCounter(int counter){
        this.counter = counter;
    }

    public int getCounter(){ return counter; }
}
