import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.Random;


public class Pirates extends Components implements Characters{
    private int state;
    private Position position;

    public Pirates(int x, int y) {
        super(x, y);
        this.position = super.getPosition();
        this.state= new Random().nextInt(2);
    }

    public void setState(int state){
        this.state=state;
    }
    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#B00000"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "P");
    }

    public void move() {
        switch (state) {
            case 0:
                setPosition(position.moveRight());
                break;

            case 1:
                setPosition(position.moveLeft());
                break;
        }
    }
    public void canPirateMove(Pirates pirate, int width){
        if ((pirate.getPosition().getX()==1 || (pirate.getPosition().getX()==(width/2)+3 && pirate.getPosition().getY()<=4)) && pirate.state==1) setState(0);

        if ((pirate.getPosition().getX()==width-2 || (pirate.getPosition().getX()==(width/2)-3 && pirate.getPosition().getY()<=4))&& pirate.state==0) setState(1);
    }

    public int getState(){
        return state;
    }
}

