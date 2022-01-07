import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;

import java.util.List;

public class Jack_The_Sparrow extends Components implements Characters{
    private Position position;
    private KeyType direction;
    public int lives;
    public int points;

    public Jack_The_Sparrow(int x, int y){
        super(x, y);
        this.lives=3;
        this.points=0;
        this.position = super.getPosition();
    }

    public void draw(TextGraphics graphics) {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#171717"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }

    public void setJackDirection(KeyType press){
        this.direction = press;
    }

    public void move() {
        switch (direction) {
            case ArrowUp -> setPosition(position.moveUp());
            case ArrowDown -> setPosition(position.moveDown());
            case ArrowRight -> setPosition(position.moveRight());
            case ArrowLeft -> setPosition(position.moveLeft());
        }
    }

    public boolean canJackMove(List<Borders> borders, List<Borders> prison){
        for(Borders border : borders){
            if(border.getPosition().getX() == getPosition().getX() && border.getPosition().getY() == getPosition().getY()){
                return true;
            }
        }
        for(Borders p : prison){
            if(p.getPosition().getX() == getPosition().getX() && p.getPosition().getY() == getPosition().getY()){
                return true;
            }
        }
        return false;
    }
    
    public void setLives(){
        this.lives--;
    }

    public void setPoints(){
        this.points++;
    }

    public KeyType getDirection(){
        return direction;
    }

    public int getPoints(){
        return points;
    }

    public boolean checkIfDead(){
        if (this.lives == 0){
            return true;
        }
        return false;
    }
}
